package com.yuhao.canteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "")
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID")
	private String id;

	@ApiModelProperty(value = "学号")
	private String studentId;

	@ApiModelProperty(value = "用户名")
	private String username;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "真实姓名")
	private String name;

	@ApiModelProperty(value = "性别")
	private String gender;

	@ApiModelProperty(value = "积分")
	private Integer point;

	@ApiModelProperty(value = "联系电话")
	private String phone;

	@ApiModelProperty(value = "电子邮件地址")
	private String email;

	@ApiModelProperty(value = "头像")
	private String avatar;

	@ApiModelProperty(value = "角色")
	private String role;

	@ApiModelProperty(value = "注册系统的日期")
	private String regDate;

	@ApiModelProperty(value = "最后登录系统的时间")
	private String lastLogin;

	@ApiModelProperty(value = "用户账号的状态")
	private String status;


}