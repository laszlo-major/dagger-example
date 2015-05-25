package com.levi9.daggerexample.communication;

import android.content.Context;

import retrofit.RetrofitError;

/**
 * Created by l.major on 5/25/2015.
 */
public class FakeCommunicationManager extends CommunicationManager {

    public FakeCommunicationManager(Context context) {
        super(context);
    }

    @Override
    public String getCurrentVersion() {
        return "Fake";
    }

    @Override
    public void getCurrentWeather(String city, WeatherResponseListener listener) {
        listener.onGetWeatherError(RetrofitError.unexpectedError("mockUrl", new Exception("mock throwing error!")));
    }
}
