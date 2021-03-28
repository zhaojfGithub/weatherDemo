package com.zhao.weather.weather_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.weather.weather_demo.entity.WeatherSite;
import com.zhao.weather.weather_demo.service.WeatherSiteService;
import com.zhao.weather.weather_demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/weatherSite")
public class WeatherSiteController {

    @Autowired
    private WeatherSiteService siteService;


    @PostMapping("addSite")
    public RestResponse<Object> addSite(@RequestParam("user_id") Long userId,
                                        @RequestParam("site") String site,
                                        @RequestParam("lat") String lat,
                                        @RequestParam("lng") String lng){
        WeatherSite weatherSite = new WeatherSite();
        weatherSite.setUserId(userId);
        weatherSite.setSite(site);
        weatherSite.setLat(lat);
        weatherSite.setLng(lng);
        if (siteService.save(weatherSite)){
            return RestResponse.success("加入成功");
        }else {
            return RestResponse.fail("加入失败，请进行开发者反馈");
        }

    }

    @GetMapping("getAllSite")
    public RestResponse<Object> getAllSite(@RequestParam("user_id") Long userId){
        QueryWrapper<WeatherSite> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<WeatherSite> list = siteService.list(queryWrapper);
        return RestResponse.success("查询成功",list);
    }

    @DeleteMapping("removeSite")
    public RestResponse<Object> removeSite(@RequestParam("user_id") Long userId,
                                           @RequestParam("id") Long id){
        QueryWrapper<WeatherSite> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        queryWrapper.eq("user_id",userId);
        if (siteService.remove(queryWrapper)){
            return RestResponse.success("删除成功");
        }else {
            return RestResponse.fail("删除失败，请进行开发者反馈");
        }

    }

}

