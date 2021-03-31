package com.zhao.weather.weather_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhao.weather.weather_demo.entity.WeatherUser;
import com.zhao.weather.weather_demo.service.WeatherUserService;
import com.zhao.weather.weather_demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
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

    /**
     * 注册
     * @param accountNumber 账号
     * @param password      密码
     */
    @PostMapping("register")
    public RestResponse<Object> register(@RequestParam("accountNumber") Long accountNumber,
                                         @RequestParam("password") String password) {
        QueryWrapper<WeatherUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_number", accountNumber);
        List<WeatherUser> list = weatherUserService.list(queryWrapper);
        if (list.size() == 0) {
            WeatherUser user = new WeatherUser();
            user.setPassword(password);
            user.setAccountNumber(accountNumber);
            if (weatherUserService.save(user)) {
                return RestResponse.success("注册成功");
            } else {
                return RestResponse.fail("注册失败，请联系开发者");
            }
        }else {
            return RestResponse.fail("注册失败，此手机号已经被使用");
        }
    }

    /**
     * 登录
     *
     * @param accountNumber 账号
     * @param password      密码
     * @return 返回用户id
     */
    @PostMapping("login")
    public RestResponse<Object> login(@RequestParam("accountNumber") Long accountNumber,
                                      @RequestParam("password") String password) {
        QueryWrapper<WeatherUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_number", accountNumber).eq("password", password);
        List<WeatherUser> list = weatherUserService.list(queryWrapper);
        if (list.size()==0){
            return RestResponse.fail("登录失败,账号或密码错误");
        }
        return RestResponse.success("登录成功", list);
    }

    /**
     * 根据userId查询个人信息
     */

    @GetMapping("user")
    public RestResponse<Object> user(@RequestParam("userId") Long userId){
        WeatherUser entity = weatherUserService.getById(userId);
        return RestResponse.success("查询成功",entity);
    }

    /**
     * 根据userId修改个人信息
     */
    @PostMapping("updateUser")
    public RestResponse<Object> updateUser(@RequestBody WeatherUser entity){

        if (weatherUserService.saveOrUpdate(entity)){
            return RestResponse.success("修改成功");
        }else {
            return RestResponse.fail("修改失败");
        }
    }

}

