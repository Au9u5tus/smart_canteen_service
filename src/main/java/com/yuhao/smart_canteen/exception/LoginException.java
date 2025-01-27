package com.yuhao.smart_canteen.exception;

import lombok.Data;

@Data
public class LoginException extends RuntimeException{
    public int code;
    private String msg;

}
