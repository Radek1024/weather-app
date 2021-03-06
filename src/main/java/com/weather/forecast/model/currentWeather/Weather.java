package com.weather.forecast.model.currentWeather;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Weather {
    private Integer id;
    private String main;
    private String description;
    private String icon;

}
