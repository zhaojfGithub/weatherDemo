package com.zhao.weather.weather_demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.zhao.weather.weather_demo.mapper")
public class WeatherConfig {
}
