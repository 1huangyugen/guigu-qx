package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @date 2023/4/5-13:10
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //1全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        System.out.println("全局");
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }


    //2特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        System.out.println("特定");
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");
    }


    //3自定义异常处理
    @ExceptionHandler(GuiguException.class)
    @ResponseBody
    public Result error(GuiguException e){
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
}
