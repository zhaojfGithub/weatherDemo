package com.zhao.weather.weather_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.weather.weather_demo.entity.WeatherSite;
import com.zhao.weather.weather_demo.entity.WeatherUser;
import com.zhao.weather.weather_demo.entity.WeatherUserColler;
import com.zhao.weather.weather_demo.service.WeatherUserCollerService;
import com.zhao.weather.weather_demo.service.WeatherUserService;
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
@RequestMapping("/weatherUserColler")
public class WeatherUserCollerController {

    @Autowired
    private WeatherUserCollerService service;

    @GetMapping("getAllSite")
    public RestResponse<Object> getAll(@RequestParam("user_id") Long userId){
        return RestResponse.success("查询成功");
    }

    @PostMapping("addUserColler")
    public RestResponse<Object> AddUserColler(@RequestParam("user_id") Long userId,
                                              @RequestParam("facility_id") Long facilityId){
        WeatherUserColler entity = new WeatherUserColler();
        entity.setId(userId);
        entity.setFacilityId(facilityId);
        entity.setCollect(1);
        if (service.save(entity)){
            return RestResponse.success("添加成功");
        }else {
            return RestResponse.fail("添加失败，请联系开发者！！！");
        }
    }

    @DeleteMapping("removeUserColler")
    public RestResponse<Object> removeUserColler(@RequestParam("user_id") Long userId,
                                                 @RequestParam("facility_id") Long facilityId){
        QueryWrapper<WeatherUserColler> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("facility_id",facilityId);
        if (service.remove(queryWrapper)){
            return RestResponse.success("删除收藏成功");
        }else {
            return RestResponse.fail("取消收藏失败，请进行开发者反馈");
        }
    }

}

