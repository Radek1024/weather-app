package com.weather.forecast.model.currentWeather;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Wind {
    private double speed;
    private int deg;
    private int gust;
}
