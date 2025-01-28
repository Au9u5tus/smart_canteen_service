package com.yuhao.canteen.exception;

import com.yuhao.canteen.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
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
