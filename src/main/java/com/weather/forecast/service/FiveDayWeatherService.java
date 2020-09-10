package com.weather.forecast.service;

import com.weather.forecast.model.fourDayWeather.FiveDayForecast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class FiveDayWeatherService {
    private final RestTemplate restTemplate;

    public FiveDayForecast getForecast(String city){
        String currentWeatherId = "3070856697cde0dd9224dc1445904678";
        String url = "https://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&appid={currentWeatherId}&lang=pl";
        return restTemplate.getForObject(url,FiveDayForecast.class,city,currentWeatherId);
    }

}
