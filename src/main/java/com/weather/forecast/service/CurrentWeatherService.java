package com.weather.forecast.service;

import com.weather.forecast.model.currentWeather.CurrentWeather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CurrentWeatherService {
    private final RestTemplate restTemplate;

    public CurrentWeather getData(String city){
        String currentWeatherId = "3070856697cde0dd9224dc1445904678";
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s&lang=pl",city,currentWeatherId);
        return restTemplate.getForObject(url, CurrentWeather.class);
    }

}
