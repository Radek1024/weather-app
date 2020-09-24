package com.weather.forecast.service;

import com.weather.forecast.model.fiveDayWeather.FiveDayForecast;
import com.weather.forecast.model.fiveDayWeather.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.*;
import java.util.*;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class FiveDayWeatherService {
    private final RestTemplate restTemplate;

    public FiveDayForecast getForecast(String city) {
        String weatherId = "3070856697cde0dd9224dc1445904678";
        String url = "https://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&appid={weatherId}&lang=pl";
        return restTemplate.getForObject(url, FiveDayForecast.class, city, weatherId);
    }

    public Map<Integer,List> getFirstDay(String city) {
        Map<Integer,List> map = new HashMap<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek())) {
                        map.put(i,getForecast(city).getList()[i]);
                    }
                });
        return map;
    }

    public Map<Integer,List> getSecondDay(String city) {
        Map<Integer,List> map = new HashMap<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(1))) {
                        map.put(i,getForecast(city).getList()[i]);
                    }
                });
        return map;
    }

    public Map<Integer,List> getThirdDay(String city) {
        Map<Integer,List> map = new HashMap<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(2))) {
                        map.put(i,getForecast(city).getList()[i]);
                    }
                });
        return map;
    }

    public Map<Integer,List> getFourthDay(String city) {
        Map<Integer,List> map = new HashMap<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(3))) {
                        map.put(i,getForecast(city).getList()[i]);
                    }
                });
        return map;
    }

    public Map<Integer,List> getFifthDay(String city) {
        Map<Integer,List> map = new HashMap<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(4))) {
                        map.put(i,getForecast(city).getList()[i]);
                    }
                });
        return map;
    }

    public Map<Integer, DayOfWeek> getDate() {
        Map<Integer, DayOfWeek> dateMap = new HashMap<>();
        IntStream.rangeClosed(0, 4)
                .forEach(i -> dateMap.put(i, LocalDate.now().plusDays(i).getDayOfWeek()));
        return dateMap;
    }

    public ArrayList<LocalTime> toDateTime(){
        ArrayList<LocalTime> list = new ArrayList<>();
        IntStream.iterate(0,i -> i +3).limit(8)
                .forEach(i ->{
                    list.add(LocalTime.MIDNIGHT.plusHours(i));
                });
        return list;
    }
    public Map<Integer,LocalDateTime> getHours(String city){
        Map<Integer,LocalDateTime> hourMap = new HashMap<>();
        IntStream.rangeClosed(0,39)
                .forEach(i-> {
                   hourMap.put(i,LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(),0, ZoneOffset.ofHours(0)));
                });
        return hourMap;
    }

}
