package com.zhao.weather.weather_demo.service.impl;

import com.zhao.weather.weather_demo.entity.WeatherFacility;
import com.zhao.weather.weather_demo.entity.WeatherFacilityQuery;
import com.zhao.weather.weather_demo.mapper.WeatherFacilityMapper;
import com.zhao.weather.weather_demo.service.WeatherFacilityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
@Service
public class WeatherFacilityServiceImpl extends ServiceImpl<WeatherFacilityMapper, WeatherFacility> implements WeatherFacilityService {

    @Override
    public List<WeatherFacilityQuery> getFacility(Long id) {
        return baseMapper.getFacility(id);
    }

    @Override
    public void updateData(Long facilityId, String text) {
        baseMapper.updateData(facilityId,text);
    }

    @Override
    public List<WeatherFacilityQuery> getUserFacility(Long id) {
        return baseMapper.getUserFacility(id);
    }
}
