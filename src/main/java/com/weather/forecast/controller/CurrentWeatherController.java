package com.weather.forecast.controller;

import com.weather.forecast.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CurrentWeatherController {
    private final CurrentWeatherService currentWeatherService;

    @PostMapping("/currentDayWeatherController")
    public String getApi(HttpSession session, Model model){
        String sName = session.getAttribute("cityName").toString();
        model.addAttribute("weather",currentWeatherService.getWeather(sName));
        model.addAttribute("dayOfWeek",currentWeatherService.getDate());
        return "OneDayWeather";
    }

}
