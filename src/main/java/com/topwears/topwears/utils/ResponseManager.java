package com.topwears.topwears.utils;

import com.topwears.topwears.models.pojos.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ResponseManager<T> {

    public ApiResponse<T> success(T data){
        return  new ApiResponse<T>("Success", HttpStatus.OK,data);
    }

    public ApiResponse<T> fail(String message){
        return  new ApiResponse<T>(message, HttpStatus.BAD_REQUEST,null);
    }
}
