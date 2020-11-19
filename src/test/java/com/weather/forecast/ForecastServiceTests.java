package com.weather.forecast;

import com.weather.forecast.model.currentWeather.Clouds;
import com.weather.forecast.model.currentWeather.Rain;
import com.weather.forecast.model.fiveDayWeather.City;
import com.weather.forecast.model.fiveDayWeather.FiveDayForecast;
import com.weather.forecast.model.fiveDayWeather.List;
import com.weather.forecast.service.FiveDayWeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ForecastServiceTests {
    private FiveDayWeatherService fiveDayWeather;

    @BeforeEach
    public void init(){
        fiveDayWeather = mock(FiveDayWeatherService.class);
    }

    @Test
    public void getForecastTest(){
        City city = new City();
        city.setName("Perth");
        long date = 1605782108;
        List list = new List();
        list.setDt(date);

        FiveDayForecast fiveDayForecast = new FiveDayForecast();
        fiveDayForecast.setCity(city);
        fiveDayForecast.setMessage(11.5);
        fiveDayForecast.setList(Collections.singletonList(list));

        FiveDayForecast response = ResponseEntity.ok(fiveDayForecast).getBody();

        when(fiveDayWeather.getForecast(city.getName())).thenReturn(response);

        assertNotNull(response);
        assertEquals("Perth",response.getCity().getName());
        assertEquals(1605782108,response.getList().get(0).getDt());
        assertEquals(11.5,response.getMessage());
    }

    @Test
    public void getFirstDayTest(){
        String city = "Sydney";
        long time = 1605782108;
        long time1= 1605793457;

        Clouds clouds = new Clouds();
        clouds.setAll(100);
        Clouds clouds1 = new Clouds();
        clouds1.setAll(33);
        Rain rain = new Rain();
        rain.setRainOneHour(80);
        rain.setRainThreeHours(50);
        Rain rain1 = new Rain();
        rain1.setRainOneHour(75);
        rain1.setRainThreeHours(25);

        List list = new List();
        list.setDt(time);
        list.setRain(rain);
        list.setClouds(clouds);
        List list1 = new List();
        list1.setDt(time1);
        list1.setRain(rain1);
        list1.setClouds(clouds1);

        java.util.List<List> listOfList = new ArrayList<>();
        Collections.addAll(listOfList,list,list1);

        when(fiveDayWeather.getFirstDay(city)).thenReturn(listOfList);

        assertNotNull(listOfList);
        assertEquals(1605782108,listOfList.get(0).getDt());
        assertEquals(1605793457,listOfList.get(1).getDt());
        assertEquals(2,listOfList.size());
        assertEquals(100,listOfList.get(0).getClouds().getAll());
        assertEquals(80,listOfList.get(0).getRain().getRainOneHour());
        assertEquals(33,listOfList.get(1).getClouds().getAll());
        assertEquals(75,listOfList.get(1).getRain().getRainOneHour());
    }
}