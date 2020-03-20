package com.drawthink.web;

import com.drawthink.common.vo.JsonResult;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)//可以处理的异常类型
    public JsonResult doHandlerRuntimeException(RuntimeException e){
        e.printStackTrace();
        System.out.println("==Global==");
        return new JsonResult(e);
    }
}
