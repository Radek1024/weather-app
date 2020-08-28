package com.weather.forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Snow {
    @JsonProperty("1h")
    private int snowOneH;
    @JsonProperty("3h")
    private int snowThreeH;
}
