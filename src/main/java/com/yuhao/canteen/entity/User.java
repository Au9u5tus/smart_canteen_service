package com.yuhao.canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("user")
public class User {

    /**
     * 用户ID
     */
	private String id;
    /**
     * 学号
     */
	private String studentId;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 真实姓名
     */
	private String name;
    /**
     * 性别
     */
	private String gender;
    /**
     * 积分
     */
	private Integer point;
    /**
     * 联系电话
     */
	private String phone;
    /**
     * 电子邮件地址
     */
	private String email;
    /**
     * 头像
     */
	private String avatar;
    /**
     * 角色
     */
	private String role;
    /**
     * 注册系统的日期
     */
	private String regDate;
    /**
     * 最后登录系统的时间
     */
	private String lastLogin;
    /**
     * 用户账号的状态
     */
	private String status;
}