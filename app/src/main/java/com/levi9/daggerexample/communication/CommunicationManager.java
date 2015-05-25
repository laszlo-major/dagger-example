package com.levi9.daggerexample.communication;

import com.levi9.daggerexample.application.DaggerExampleApplication;
import com.levi9.daggerexample.model.WeatherData;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Major on 5/24/2015.
 */
public class CommunicationManager {

    private static final String TAG = CommunicationManager.class.getSimpleName();

    @Inject
    WeatherMapApi mWeatherMapApi;


    public CommunicationManager(Context context) {
        ((DaggerExampleApplication) context.getApplicationContext()).getComponent().inject(this);
    }

    public void getCurrentWeather(String city, final WeatherResponseListener listener) {
        mWeatherMapApi.getWeatherCity(city, new Callback<WeatherData>() {
            @Override
            public void success(WeatherData weatherData, Response response) {
                Log.d(TAG, "success");
                listener.onGetWeatherSuccess(weatherData);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "error");
                listener.onGetWeatherError(error);
            }
        });
    }

    public void getCurrentWeather(double longitude, double latitude, final WeatherResponseListener listener) {
        mWeatherMapApi.getWeatherCoords(longitude, latitude, new Callback<WeatherData>() {
            @Override
            public void success(WeatherData weatherData, Response response) {
                Log.d(TAG, "success");
                listener.onGetWeatherSuccess(weatherData);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, "error");
                listener.onGetWeatherError(error);
            }
        });
    }

    public String getCurrentVersion() {
        return "Real";
    }

}
