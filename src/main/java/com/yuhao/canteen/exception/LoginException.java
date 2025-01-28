package com.yuhao.canteen.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginException extends RuntimeException{
    public int code;
    private String msg;



}
