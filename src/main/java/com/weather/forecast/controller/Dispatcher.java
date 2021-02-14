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
    public String decide(City city, HttpSession session){
        session.setAttribute("cityName",city.getName());
        if(city.getId()==2) {
            return "forward:/fiveDayWeatherResult";
        }
        if(city.getId()==1) {
            //model.addAttribute("cityName", city.getId());
            return "forward:/currentDayWeatherResult";
        }
        else
            return "Welcome";
    }
}
