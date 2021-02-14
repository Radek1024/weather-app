package com.weather.forecast.controller;

import com.weather.forecast.model.currentWeather.CurrentWeather;
import com.weather.forecast.service.CurrentWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class CurrentWeatherController {
    private final CurrentWeatherService currentWeatherService;

    @PostMapping("/currentDayWeatherResult")
    public String getApi(HttpSession session, Model model){
        model.addAttribute("weather",currentWeatherService.getData(session.getAttribute("cityName").toString()));
        return "Footer";
    }

}
