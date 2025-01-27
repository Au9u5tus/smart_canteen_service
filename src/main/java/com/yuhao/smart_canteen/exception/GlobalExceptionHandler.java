package com.yuhao.smart_canteen.exception;

import com.yuhao.smart_canteen.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public Result handleLoginException(LoginException loginException){
        Result result=new Result();
        result.setCode(loginException.getCode());
        result.setMsg(loginException.getMsg());
        return result;
    }
}
