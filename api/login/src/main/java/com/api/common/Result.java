package com.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @className: Restult
 * @description: 统一后台返回格式
 * @create: 2021-08-7 21:08
 **/
@Data
public class Result {

    // 返回的状态码
    private int code;

    // 返回的信息提示
    private String message;

    // 返回的数据
    private Object result;

    //时间戳
    private Long timestamp;

    private boolean success;


    private Result() {
    }

    private Result(int code, String message, Object result,long timestamp,boolean success) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.timestamp = timestamp;
        this.success = success;
    }



    @Deprecated
    public static Result resultError(boolean r){
        if(r){
            return ok();
        }else {
            return error();
        }
    }

    public static Result result(boolean r){
        if(r){
            return ok();
        }else {
            return error();
        }
    }

    public static Result ok(){
        return ok(ResultConstant.OK_MESSAGE,null);
    }

    public static Result ok(Object result){
        return ok(ResultConstant.OK_MESSAGE,result);
    }

    public static Result ok(String message, Object result){
        return new Result(ResultConstant.OK,message,result,System.currentTimeMillis(),true);
    }



    public static Result error(){
        return error(ResultConstant.ERROR_MESSAGE,null);
    }

    public static Result error(Object result){
        return error(ResultConstant.ERROR_MESSAGE,result);
    }

    public static Result error(String message, Object result){
        return new Result(ResultConstant.ERROR,message,result,System.currentTimeMillis(),false);
    }
}
