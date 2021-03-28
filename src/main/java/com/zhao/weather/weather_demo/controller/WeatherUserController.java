package com.zhao.weather.weather_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.weather.weather_demo.entity.WeatherUser;
import com.zhao.weather.weather_demo.service.WeatherUserService;
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
@RequestMapping("/weatherUser")
public class WeatherUserController {

    @Autowired
    private WeatherUserService weatherUserService;

    @GetMapping("findAll")
    public List<WeatherUser> finaAllTeacher(){
        List<WeatherUser> list=weatherUserService.list(null);
        return list;
    }

    @GetMapping("addOneData")
    public boolean addOneData(){
        WeatherUser user = new WeatherUser();
        user.setName("key1");
        user.setEmail("toy111111@163.com");
        user.setAccountNumber(111111111L);
        user.setPassword("toy111111");
        return weatherUserService.save(user);
    }

    @PostMapping("login")
    public String login(@RequestParam("name") String name,
                         @RequestParam("accountNumber") Long accountNumber,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email){
        WeatherUser user = new WeatherUser();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAccountNumber(accountNumber);
        if(weatherUserService.save(user)){
            return "注册成功";
        }else {
            return "注册失败" ;
        }
    }

    @GetMapping("register")
    public List<WeatherUser> register(@RequestParam("accountNumber") Long accountNumber,
                         @RequestParam("password") String password){

        QueryWrapper<WeatherUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_number",accountNumber).eq("password",password);
        List<WeatherUser> list=weatherUserService.list(queryWrapper);
        return list;
    }

}

