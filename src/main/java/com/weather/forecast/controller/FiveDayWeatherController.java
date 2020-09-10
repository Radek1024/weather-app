package com.weather.forecast.controller;

import com.weather.forecast.model.fourDayWeather.FiveDayForecast;
import com.weather.forecast.service.FiveDayWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class FiveDayWeatherController {
    private final FiveDayWeatherService weatherService;

    @RequestMapping("/")
    public String getIndex(Model model) {
        FiveDayForecast fiveDayForecast = new FiveDayForecast();
        model.addAttribute("currentWeather", fiveDayForecast);
        return "FindCity";
    }

    @PostMapping("/weatherResult")
    public String getFiveForecast(String city, Model model) {
        model.addAttribute("weather",weatherService.getForecast(city));
        return "Index";
    }

}
