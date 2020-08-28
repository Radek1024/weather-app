package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Main {
    private double temp;
    @JsonProperty("feels_like")
    private double feelsLike;
    private double pressure;
    private int humidity;
    @JsonProperty("temp_min")
    private double tempMin;
    @JsonProperty("temp_max")
    private double tempMax;
    @JsonProperty("sea_level")
    private double seaLevel;
    @JsonProperty("grnd_level")
    private double groundLevel;
}
