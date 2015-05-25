package com.levi9.daggerexample.model;

/**
 * Created by l.major on 5/25/2015.
 */
public class WeatherData{
    Weather main;
    Country sys;
    String name;

    public Weather getMain() {
        return main;
    }

    public Country getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }
}