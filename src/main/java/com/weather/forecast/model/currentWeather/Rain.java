package com.weather.forecast.model.currentWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {
    @JsonProperty("1h")
    private int rainOneHour;
    @JsonProperty("3h")
    private int rainThreeHours;
}
