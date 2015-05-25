package com.levi9.daggerexample.communication;

import com.levi9.daggerexample.model.WeatherData;

import retrofit.RetrofitError;

/**
 * Created by l.major on 5/25/2015.
 */
public interface WeatherResponseListener {
    void onGetWeatherSuccess(WeatherData weatherData);
    void onGetWeatherError(RetrofitError error);
}
