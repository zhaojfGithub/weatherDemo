package com.zhao.weather.weather_demo.mapper;

import com.zhao.weather.weather_demo.entity.WeatherFacility;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.weather.weather_demo.entity.WeatherFacilityQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
public interface WeatherFacilityMapper extends BaseMapper<WeatherFacility> {

    List<WeatherFacilityQuery> getFacility(@Param("id") Long id);

    void updateData(@Param("facility_id") Long facilityId , @Param("text") String text);

    List<WeatherFacilityQuery> getUserFacility(@Param("id") Long id);
}
