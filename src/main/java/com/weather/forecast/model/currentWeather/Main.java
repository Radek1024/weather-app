package com.weather.forecast.model.currentWeather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
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
