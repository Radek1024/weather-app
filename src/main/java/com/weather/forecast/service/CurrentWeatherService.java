package com.weather.forecast.service;

import com.weather.forecast.model.currentWeather.CurrentWeather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CurrentWeatherService {
    private final RestTemplate restTemplate;

    public CurrentWeather getData(String city){
        String appId = "3070856697cde0dd9224dc1445904678";
        String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={currentWeatherId}&lang=pl";
        return restTemplate.getForObject(url, CurrentWeather.class,city,appId);
    }

}
