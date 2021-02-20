package com.weather.forecast.service;

import com.weather.forecast.model.currentWeather.CurrentWeather;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CurrentWeatherService {
    private final RestTemplate restTemplate;

    public CurrentWeather getWeather(String city){
        String appId = "3070856697cde0dd9224dc1445904678";
        String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={currentWeatherId}&lang=pl";
        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity(url, CurrentWeather.class, city, appId);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return new CurrentWeather();
    }

    public DayOfWeek getDate(){
        return LocalDate.now().getDayOfWeek();
    }

}
