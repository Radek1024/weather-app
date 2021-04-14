package com.weather.forecast.service;

import com.weather.forecast.model.currentWeather.CurrentWeather;
import com.weather.forecast.utils.ApiConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CurrentWeatherService {
    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;

    public CurrentWeather getWeather(String city){
        String url = "https://api.openweathermap.org/data/2.5/weather?q={city}&units=metric&appid={currentWeatherId}&lang=pl";
        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity(url, CurrentWeather.class, city, apiConfig.getKey());
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return new CurrentWeather();
    }

    public String getDate(){
        return LocalDate.now().format(
                DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy",
                Locale.forLanguageTag("pl")));
    }

}
