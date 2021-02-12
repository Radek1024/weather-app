package com.weather.forecast.controller;


import com.weather.forecast.model.fiveDayWeather.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller("/")
public class Dispatcher {

    @RequestMapping
    public String setCityName(Model model){
        model.addAttribute("cityObject",new City());
        return "Welcome";
    }
    @PostMapping("/decision")
    public String decide(City city, Model model){
        if(city.getId()==2) {
            model.addAttribute("name",city.getName());
            return "forward:/fiveDayWeatherResult";
        }
        if(city.getId()==1) {
            model.addAttribute("id", city.getId());
            return "redirect:/currentDayWeatherResult";
        }
        else
            return "Welcome";
    }
}
