package com.levi9.daggerexample.dagger;

import com.levi9.daggerexample.communication.CommunicationManager;
import com.levi9.daggerexample.communication.MockCommunicationManager;
import com.levi9.daggerexample.communication.WeatherMapApi;

import org.mockito.Mockito;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by l.major on 5/25/2015.
 */
@Module
public class MockExampleModule {

    private Context mContext;

    public MockExampleModule(Context context) {
        this.mContext = context;
    }

    @Singleton
    @Provides
    public CommunicationManager provideCommunication() {
        return new MockCommunicationManager(mContext);
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

    @Provides
    @Singleton
    public LocationManager provideLocationManager() {
        System.setProperty("dexmaker.dexcache", mContext.getCacheDir().getPath());
        LocationManager locationManager = Mockito.mock(LocationManager.class);
        Location fakeLocation = new Location("fake");
        fakeLocation.setLatitude(44.81);
        fakeLocation.setLongitude(20.46);
        when(locationManager.getBestProvider(any(Criteria.class), anyBoolean())).thenReturn("faaaaake");
        when(locationManager.getLastKnownLocation(anyString())).thenReturn(fakeLocation);
        
        return locationManager;
    }

}
