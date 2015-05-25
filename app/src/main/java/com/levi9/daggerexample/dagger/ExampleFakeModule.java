package com.levi9.daggerexample.dagger;

import com.levi9.daggerexample.communication.CommunicationManager;
import com.levi9.daggerexample.communication.FakeCommunicationManager;
import com.levi9.daggerexample.communication.WeatherMapApi;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by l.major on 5/25/2015.
 */
@Module
public class ExampleFakeModule {

    private Context mContext;

    public ExampleFakeModule(Context context) {
        this.mContext = context;
    }

    @Singleton
    @Provides
    public CommunicationManager provideCommunication() {
        return new FakeCommunicationManager(mContext);
    }


    @Provides
    @Singleton
    public RestAdapter provideRestAdapter() {
        return new RestAdapter.Builder() //
                .setClient(new OkClient()) //
                .setEndpoint(WeatherMapApi.API_URL) //
                .build();
    }

    @Provides
    @Singleton
    public WeatherMapApi provideWeatherApi(RestAdapter restAdapter) {
        return restAdapter.create(WeatherMapApi.class);
    }

}
