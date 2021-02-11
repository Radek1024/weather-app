package com.weather.forecast.controller;

import com.weather.forecast.model.currentWeather.CurrentWeather;
import com.weather.forecast.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CurrentWeatherController {
    private final CurrentWeatherService currentWeatherService;

    @RequestMapping("/api")
    public String getIndex(Model model){
        CurrentWeather currentWeather = new CurrentWeather();
        model.addAttribute("currentWeather", currentWeather);
        return "FindCity";
    }

    @GetMapping("/currentDayWeatherResult")
    public String getApi(String cityName, Model model){
        model.addAttribute("weather",currentWeatherService.getData(cityName));
        return "Result";
    }


}
