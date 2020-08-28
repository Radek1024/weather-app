package com.weather.forecast.controller;

import com.weather.forecast.model.CurrentWeather;
import com.weather.forecast.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CurrentWeatherController {
    private final CurrentWeatherService currentWeatherService;

    @GetMapping("/api/{city}")
    public CurrentWeather getApi(@PathVariable String city){
        return currentWeatherService.getData(city);
    }


}
