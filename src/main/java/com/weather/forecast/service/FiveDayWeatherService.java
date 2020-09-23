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
        //List[] arr = new List[8];
        Map<Integer,List> map = new HashMap<>();
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(3)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek())) {
                        map.put(i,getForecast(city).getList()[i]);
                    }
                });
        return map;
    }

    public List[] getSecondDay(String city) {
        List[] arr1 = new List[40];
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(3)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(1))) {
                            arr1[i] = getForecast(city).getList()[i];
                    }
                });
        return arr1;
    }

    public List[] getThirdDay(String city) {
        List[] arr1 = new List[40];
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(3)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(2))) {
                        arr1[i] = getForecast(city).getList()[i];
                    }
                });
        return arr1;
    }

    public List[] getFourthDay(String city) {
        List[] arr1 = new List[40];
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(3)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(3))) {
                        arr1[i] = getForecast(city).getList()[i];
                    }
                });
        return arr1;
    }

    public List[] getFifthDay(String city) {
        List[] arr1 = new List[40];
        IntStream.rangeClosed(0, 39)
                .forEach(i -> {
                    if (LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(), 0, ZoneOffset.ofHours(3)).getDayOfWeek()
                            .equals(LocalDateTime.now().getDayOfWeek().plus(4))) {
                        arr1[i] = getForecast(city).getList()[i];
                    }
                });
        return arr1;
    }

    public Map<Integer, DayOfWeek> getDate(String city) {
        Map<Integer, DayOfWeek> dateMap = new HashMap<>();
        IntStream.rangeClosed(0, 4)
                .forEach(i -> dateMap.put(i, LocalDate.now().plusDays(i).getDayOfWeek()));
        return dateMap;
    }

    public LocalDateTime[] toDateTime(String city){
        LocalDateTime[] time = new LocalDateTime[40];
        IntStream.rangeClosed(0,39)
                .forEach(i->{
                    time[i] = LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(),0,ZoneOffset.ofHours(2));
                });
        return time;
    }
    public Map<Integer,LocalDateTime> getHours(String city){
        Map<Integer,LocalDateTime> imgMap = new HashMap<>();
        IntStream.rangeClosed(0,39)
                .forEach(i-> {
                   imgMap.put(i,LocalDateTime.ofEpochSecond(getForecast(city).getList()[i].getDt(),0, ZoneOffset.ofHours(2)));
                });
        //String url = " http://openweathermap.org/img/wn/{code}@2x.png";
        //return restTemplate.getForObject(url,String.class,code);
        return imgMap;
    }

}
