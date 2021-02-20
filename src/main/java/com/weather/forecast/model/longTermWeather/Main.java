package com.weather.forecast.model.longTermWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    @JsonProperty("temp")
    private int temperature;
    @JsonProperty("feels_like")
    private int feelsLike;
    @JsonProperty("temp_min")
    private int tempMin;
    @JsonProperty("temp_max")
    private int tempMax;
    private int pressure;
    @JsonProperty("sea_level")
    private int seaLevel;
    @JsonProperty("grnd_level")
    private int groundLevel;
    private int humidity;
    @JsonProperty("temp_kf")
    private int tempKf;

}
