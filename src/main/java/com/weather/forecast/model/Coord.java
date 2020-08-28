package com.weather.forecast.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Coord {
    private double lon;
    private double lat;
}
