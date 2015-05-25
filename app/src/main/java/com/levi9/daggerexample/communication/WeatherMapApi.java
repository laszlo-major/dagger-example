package com.levi9.daggerexample.communication;

import com.levi9.daggerexample.model.WeatherData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by l.major on 5/25/2015.
 */
public interface WeatherMapApi {

    public static final String API_URL = "http://api.openweathermap.org/data/2.5";

    @GET("/weather?units=metric")
    void getWeatherCity(@Query("q") String cities, Callback<WeatherData> callback);

    @GET("/weather?units=metric")
    void getWeatherCoords(@Query("lon") double longitude, @Query("lat") double latitude, Callback<WeatherData> callback);

}
