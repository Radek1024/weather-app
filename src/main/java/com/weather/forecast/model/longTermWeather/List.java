package com.weather.forecast.model.longTermWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weather.forecast.model.currentWeather.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    private long dt;
    private Main main;
    private Weather[] weather;
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Snow snow;
    private Double pop;
    private int visibility;
    @JsonProperty("dt_txt")
    private String dtTxt;

}
