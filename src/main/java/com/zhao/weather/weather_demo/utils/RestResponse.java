package com.zhao.weather.weather_demo.utils;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public RestResponse(){}

    public RestResponse(int code,String message,T data){
        this.code=code;
        this.setMsg(message);
        this.data=data;
    }

    public RestResponse(int code ,T data){
        this.code=code;
        this.data=data;
    }

    public RestResponse(int code,String message){
        this.code=code;
        this.setMsg(message);
    }

    public static <T> RestResponse<T> success(T data){
        return new RestResponse<T>(200,null,data);
    }

    public static <T> RestResponse<T> success(String msg){
        return new RestResponse<T>(200,msg);
    }

    public static <T> RestResponse<T> success(String msg,T data){
        return new RestResponse<T>(200, msg, data);
    }

    public static <T> RestResponse<T> fail(String msg){
        return new RestResponse<T>(500, msg,null);
    }
}
