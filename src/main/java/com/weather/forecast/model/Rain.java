package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Rain {
    @JsonProperty("1h")
    private int rainOneH;
    @JsonProperty("3h")
    private int rainThreeH;
}
