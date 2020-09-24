package com.weather.forecast.controller;

import com.weather.forecast.model.fiveDayWeather.City;
import com.weather.forecast.model.fiveDayWeather.FiveDayForecast;
import com.weather.forecast.service.FiveDayWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class FiveDayWeatherController {
    private final FiveDayWeatherService weatherService;

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("cityObject", new City());
        return "FindCity";
    }

    @PostMapping("/weatherResult")
    public String getFiveForecast(String name, Model model) {
        model.addAttribute("weather1",weatherService.getForecast(name));
        model.addAttribute("firstDay",weatherService.getFirstDay(name));
        model.addAttribute("secondDay",weatherService.getSecondDay(name));
        model.addAttribute("thirdDay",weatherService.getThirdDay(name));
        model.addAttribute("fourthDay",weatherService.getFourthDay(name));
        model.addAttribute("fifthDay",weatherService.getFifthDay(name));
        model.addAttribute("dayOfWeek",weatherService.getDate());
        model.addAttribute("day", LocalDateTime.now());
        model.addAttribute("hours",weatherService.getHours(name));
        model.addAttribute("h",weatherService.toDateTime());

        return "Index";
    }

}
