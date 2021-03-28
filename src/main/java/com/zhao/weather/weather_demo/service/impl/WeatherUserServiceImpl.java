package com.zhao.weather.weather_demo.service.impl;

import com.zhao.weather.weather_demo.entity.WeatherUser;
import com.zhao.weather.weather_demo.mapper.WeatherUserMapper;
import com.zhao.weather.weather_demo.service.WeatherUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
@Service
public class WeatherUserServiceImpl extends ServiceImpl<WeatherUserMapper, WeatherUser> implements WeatherUserService {

}
