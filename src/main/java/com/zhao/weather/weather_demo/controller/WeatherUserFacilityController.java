package com.zhao.weather.weather_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.weather.weather_demo.entity.WeatherFacility;
import com.zhao.weather.weather_demo.entity.WeatherUser;
import com.zhao.weather.weather_demo.entity.WeatherUserFacility;
import com.zhao.weather.weather_demo.service.WeatherUserFacilityService;
import com.zhao.weather.weather_demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
@RestController
@RequestMapping("/weatherUserFacility")
public class WeatherUserFacilityController {

    @Autowired
    private WeatherUserFacilityService service;

    @GetMapping("getAllSite")
    public RestResponse<Object> getAll(@RequestParam("user_id") Long userId) {
        return RestResponse.success("查询成功");
    }

    @PostMapping("addUserFacility")
    public RestResponse<Object> AddUserFacility(@RequestParam("user_id") Long userId,
                                                @RequestParam("facility_id") Long facilityId) {
        WeatherUserFacility entity = new WeatherUserFacility();
        entity.setId(userId);
        entity.setFacilityId(facilityId);
        entity.setCollect(1);
        if (service.save(entity)) {
            return RestResponse.success("添加成功");
        } else {
            return RestResponse.fail("添加失败，请联系开发者！！！");
        }
    }

    @PostMapping("amendUserFacility")
    public RestResponse<Object> amendUserFacility(@RequestParam("user_id") Long userId,
                                                  @RequestParam("facility_id") Long facilityId,
                                                  @RequestParam("collect") Integer collect) {
        QueryWrapper<WeatherUserFacility> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userId);
        queryWrapper.eq("facility_id", facilityId);
        WeatherUserFacility entity = new WeatherUserFacility();
        boolean isUpdate;
        if (collect == 1) {
            entity.setCollect(0);
        } else {
            entity.setCollect(1);
        }
        isUpdate=service.update(entity, queryWrapper);
        if (isUpdate) {
            return RestResponse.success("修改成功");
        } else {
            return RestResponse.fail("修改失败，请进行开发者反馈");
        }
    }

}

