package com.weather.forecast.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Sys {
    private int type;
    private int id;
    private String Message;
    private String Country;
    private int sunrise;
    private int sunset;
}
