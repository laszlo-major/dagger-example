package com.levi9.daggerexample.communication;

import com.levi9.daggerexample.model.Main;
import com.levi9.daggerexample.model.Weather;
import com.levi9.daggerexample.model.WeatherData;

import org.mockito.Mockito;

import android.content.Context;

import retrofit.RetrofitError;

import static org.mockito.Mockito.when;

/**
 * Created by l.major on 5/25/2015.
 */
public class MockCommunicationManager extends CommunicationManager {

    public MockCommunicationManager(Context context) {
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

    @Override
    public void getCurrentWeather(double longitude, double latitude, WeatherResponseListener listener) {
        WeatherData weatherData = Mockito.mock(WeatherData.class);
        Weather weather = Mockito.mock(Weather.class);
        when(weatherData.getMain()).thenReturn(weather);
        when(weather.getTemp()).thenReturn("666");
        when(weatherData.getName()).thenReturn("Mockito'd");
        listener.onGetWeatherSuccess(weatherData);
    }
}
