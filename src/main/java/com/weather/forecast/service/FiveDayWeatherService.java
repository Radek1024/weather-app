package com.weather.forecast.service;

import com.weather.forecast.model.fiveDayWeather.FiveDayForecast;
import com.weather.forecast.model.fiveDayWeather.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        String weatherId = "";
        String url = "https://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&appid={weatherId}&lang=pl";
        ResponseEntity<FiveDayForecast> request = restTemplate.getForEntity(url, FiveDayForecast.class, city, weatherId);
        if (request.getStatusCode() == HttpStatus.OK){
            return request.getBody();
        }
        return null;
    }

    public ArrayList<List> getFirstDay(String city) {
        ArrayList<List> list = new ArrayList<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek())) {
                        list.add(getForecast(city).getList()[i]);
                    }
                });
        return list;
    }

    public ArrayList<List> getSecondDay(String city) {
        ArrayList<List> list = new ArrayList<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(1))) {
                        list.add(getForecast(city).getList()[i]);
                    }
                });
        return list;
    }

    public ArrayList<List> getThirdDay(String city) {
        ArrayList<List> list = new ArrayList<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(2))) {
                        list.add(getForecast(city).getList()[i]);
                    }
                });
        return list;
    }

    public ArrayList<List> getFourthDay(String city) {
        ArrayList<List> list = new ArrayList<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(3))) {
                        list.add(getForecast(city).getList()[i]);
                    }
                });
        return list;
    }

    public ArrayList<List> getFifthDay(String city) {
        ArrayList<List> list = new ArrayList<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(0)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(4))) {
                        list.add(getForecast(city).getList()[i]);
                    }
                });
        return list;
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
