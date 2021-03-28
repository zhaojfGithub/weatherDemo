package com.zhao.weather.weather_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.weather.weather_demo.entity.WeatherFacility;
import com.zhao.weather.weather_demo.entity.WeatherSite;
import com.zhao.weather.weather_demo.service.WeatherFacilityService;
import com.zhao.weather.weather_demo.service.WeatherSiteService;
import com.zhao.weather.weather_demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
@RestController
@RequestMapping("/weatherFacility")
public class WeatherFacilityController {

    @Autowired
    private WeatherFacilityService siteService;

    @GetMapping("getAllFacility")
    public RestResponse<Object> getAllSite(){
        List<WeatherFacility> list = siteService.list();
        return RestResponse.success("查找成功",list);
    }

    @PostMapping("addFacility")
    public RestResponse<Object> addFacility(@RequestParam ("facility_uuid") String facility_uuid,
                                            @RequestParam ("facility_site") String facility_site){
        WeatherFacility entity = new WeatherFacility();
        entity.setFacilityUuid(facility_uuid);
        entity.setFacilitySite(facility_site);
        if (siteService.save(entity)){
            return RestResponse.success("加入成功");
        }
        return RestResponse.fail("加入失败，请联系开发者!!!");
    }
}

