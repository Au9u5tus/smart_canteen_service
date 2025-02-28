package com.yuhao.canteen.common;

import com.yuhao.canteen.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="响应")
public class Result<T>  {
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    @ApiModelProperty(value = "编码：0表示成功，其他值表示失败")
    private int code = 0;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String msg = "success";
    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    public static <T>Result<T> ok(T data,String message) {
        Result<T> result=new Result<>();
        result.setCode(Constant.SUCCESS);
        result.setMsg(message);
        result.setData(data);
        return result;
    }

    public static <T>Result<T> ok(String message) {
        return ok(null,message);
    }

    public static <T>Result<T> failture(String msg) {
        Result<T> result=new Result<>();
        result.setCode(Constant.FAIL);
        result.setMsg(msg);
        return result;
    }

    public boolean success(){
        return code == 0;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
