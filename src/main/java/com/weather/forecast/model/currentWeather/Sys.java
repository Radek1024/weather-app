package com.weather.forecast.model.currentWeather;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Sys {
    private int type;
    private int id;
    private String message;
    private String country;
    private int sunrise;
    private int sunset;
}
