package com.weather.forecast.model.fiveDayWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;


@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FiveDayForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int code;
    private double message;
    private City city;
    private int cnt;
    private List[] list;
}
