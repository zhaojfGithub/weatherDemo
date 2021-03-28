package com.zhao.weather.weather_demo.controller;


import com.zhao.weather.weather_demo.entity.WeatherFeedback;
import com.zhao.weather.weather_demo.entity.WeatherSite;
import com.zhao.weather.weather_demo.service.WeatherFeedbackService;
import com.zhao.weather.weather_demo.service.WeatherSiteService;
import com.zhao.weather.weather_demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhao
 * @since 2021-03-08
 */
@RestController
@RequestMapping("/weatherFeedback")
public class WeatherFeedbackController {

    @Autowired
    private WeatherFeedbackService service;

    @PostMapping("addFeedback")
    public RestResponse<Object> addFeedback(@RequestParam("user_id") Long userId,
                                            @RequestParam("feedback") String feedback){
        WeatherFeedback weatherFeedback = new WeatherFeedback();
        weatherFeedback.setUserId(userId);
        weatherFeedback.setFeedback(feedback);
        if (service.save(weatherFeedback)){
            return RestResponse.success("加入成功");
        }else {
            return RestResponse.fail("加入失败，请进行开发者反馈");
        }
    }

}

