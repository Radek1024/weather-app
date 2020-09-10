package com.weather.forecast.model.fourDayWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties
public class FiveDayForecast {
    private int code;
    private double message;
    private City city;
    private int cnt;
    private List[] list;
}
