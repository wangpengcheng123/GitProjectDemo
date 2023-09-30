package com.wang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e){
        String result="出异常了进了----GlobalExceptionHandler";
        if(e instanceof MyException){
            result=((MyException) e).getMsg();
        }
         return result;
    }
}
