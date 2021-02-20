package com.weather.forecast.controller;

import com.weather.forecast.service.LongTermWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class LongTermWeatherController {
    private final LongTermWeatherService weatherService;

    @PostMapping("/LongTermWeatherController")
    public String getFiveForecast(Model model, HttpSession session) {

        model.addAttribute("weather1", weatherService.getForecast(session.getAttribute("cityName").toString()));
        model.addAttribute("firstDay", weatherService.getFirstDay());
        model.addAttribute("secondDay", weatherService.getSecondDay());
        model.addAttribute("thirdDay", weatherService.getThirdDay());
        model.addAttribute("fourthDay", weatherService.getFourthDay());
        model.addAttribute("fifthDay", weatherService.getFifthDay());
        model.addAttribute("dayOfWeek", weatherService.getDate());
        model.addAttribute("day", LocalDateTime.now());
        model.addAttribute("hours", weatherService.getHours());
        model.addAttribute("h", weatherService.toDateTime());

        return "LongTermWeather";
    }

}
