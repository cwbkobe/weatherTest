package com.example.caiwb.weathertest.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by caiwb on 2018/2/25.
 */

public class Weather {

    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
