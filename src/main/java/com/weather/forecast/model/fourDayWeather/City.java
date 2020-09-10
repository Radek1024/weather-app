package com.weather.forecast.model.fourDayWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
    private int id;
    private String name;
    private String country;
    private int timezone;
    private long sunrise;
    private long sunset;
    private Map<String,Double> coord;
}
