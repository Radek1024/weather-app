package com.weather.forecast.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "api")
@Data
public class ApiConfig {
    private String key;
}
