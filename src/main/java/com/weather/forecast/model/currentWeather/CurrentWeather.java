package com.weather.forecast.model.currentWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
@JsonIgnoreProperties
public class CurrentWeather {
    private Map<String,Double> coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private Clouds clouds;
    private Map<String,Integer> rain;
    private Map<String,Integer> snow;
    private Sys sys;
    private int Timezone;
    @JsonProperty("id")
    private int cityId;
    @JsonProperty("name")
    private String cityName;
    private int cod;
}
