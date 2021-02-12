package com.weather.forecast.controller;

import com.weather.forecast.service.FiveDayWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class FiveDayWeatherController {
    private final FiveDayWeatherService weatherService;

    @PostMapping("/fiveDayWeatherResult")
    public String getFiveForecast(String cityName, Model model) {

        model.addAttribute("weather1", weatherService.getForecast(cityName));
        model.addAttribute("firstDay", weatherService.getFirstDay());
        model.addAttribute("secondDay", weatherService.getSecondDay());
        model.addAttribute("thirdDay", weatherService.getThirdDay());
        model.addAttribute("fourthDay", weatherService.getFourthDay());
        model.addAttribute("fifthDay", weatherService.getFifthDay());
        model.addAttribute("dayOfWeek", weatherService.getDate());
        model.addAttribute("day", LocalDateTime.now());
        model.addAttribute("hours", weatherService.getHours());
        model.addAttribute("h", weatherService.toDateTime());

        return "Result";
    }

}
