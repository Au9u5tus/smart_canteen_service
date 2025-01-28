package com.yuhao.canteen.constant;

public enum SystemMessage {
    NAME_OR_PWD_ERROR(401,"用户名或密码错误"),
    TOKEN_OVER_TIME(402,"token过期失效");

    SystemMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
