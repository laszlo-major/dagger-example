package com.levi9.daggerexample.model;

/**
 * Created by l.major on 5/25/2015.
 */

public class Weather{
    String humidity;
    String temp;
    String temp_max;
    String temp_min;

    public String getTemp() {
        double celsius = Float.parseFloat(temp) - 273.15;
        return String.format("%02f", celsius);
    }
}