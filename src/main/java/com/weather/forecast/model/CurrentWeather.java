package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {
    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    private Sys sys;
    private int Timezone;
    @JsonProperty("id")
    private int cityId;
    @JsonProperty("name")
    private String cityName;
    private int cod;
}
