package com.yuhao.canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yuhao.canteen.validate.LoginUser;
import com.yuhao.canteen.validate.RegisterUser;
import lombok.Data;

import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

/**
 * 用户实体类，对应数据库中的 USER 表，用于存储用户的基本信息。
 * 该类使用了 Lombok 的 @Data 注解，自动生成 getter、setter、toString 等方法。
 */
@Data
@TableName("USER")
//@JsonIgnoreProperties({"password"})
// 定义分组顺序
public class User {

    /**
     * 用户的唯一标识符，在数据库中作为主键。
     */
    private String id;

    /**
     * 用户的学号，该字段不能为空，且长度不能超过 50 个字符。
     * 使用 @NotBlank 注解确保学号不为空且去除首尾空格后长度大于 0。
     * 使用 @Size 注解限制学号的最大长度。
     */
    @NotBlank(groups = {RegisterUser.class}, message = "学号不能为空")
    @Size(groups = {RegisterUser.class},max = 50, message = "学号长度不能超过50")
    private String studentId;

    /**
     * 用户的用户名，该字段不能为空，且长度不能超过 50 个字符。
     * 使用 @NotBlank 注解确保用户名不为空且去除首尾空格后长度大于 0。
     * 使用 @Size 注解限制用户名的最大长度。
     */
    @NotBlank(groups = {RegisterUser.class, LoginUser.class},message = "用户名不能为空")
    @Size(groups = {RegisterUser.class, LoginUser.class},max = 50, message = "用户名长度不能超过50")
    private String username;

    /**
     * 用户的密码，该字段不能为空，且长度必须在 6 到 255 个字符之间。
     * 使用 @NotBlank 注解确保密码不为空且去除首尾空格后长度大于 0。
     * 使用 @Size 注解限制密码的长度范围，以保证密码的安全性。
     */
    @NotBlank(groups = {RegisterUser.class, LoginUser.class},message = "密码不能为空")
    @Size(groups = {RegisterUser.class, LoginUser.class},min = 6, max = 255, message = "密码长度必须在6到255之间")
    private String password;

    /**
     * 用户的真实姓名，该字段不能为空，且长度不能超过 100 个字符。
     * 使用 @NotBlank 注解确保真实姓名不为空且去除首尾空格后长度大于 0。
     * 使用 @Size 注解限制真实姓名的最大长度。
     */
    @NotBlank(groups = {RegisterUser.class},message = "真实姓名不能为空")
    @Size(groups = {RegisterUser.class},max = 100, message = "真实姓名长度不能超过100")
    private String name;

    /**
     * 用户的性别，该字段不能为空，且长度不能超过 2 个字符。
     * 使用 @NotBlank 注解确保性别不为空且去除首尾空格后长度大于 0。
     * 使用 @Size 注解限制性别的最大长度。
     */
    @NotBlank(groups = {RegisterUser.class},message = "性别不能为空")
    @Size(groups = {RegisterUser.class},max = 2, message = "性别长度不能超过2")
    private String gender;

    /**
     * 用户的积分，用于记录用户在系统中的积分数量。
     */
    private Float point;

    /**
     * 用户的联系电话。
     */
    private String phone;

    /**
     * 用户的电子邮件地址，该字段必须是有效的邮箱格式，且长度不能超过 100 个字符。
     * 使用 @Email 注解验证邮箱地址的格式是否正确。
     * 使用 @Size 注解限制邮箱地址的最大长度。
     */
    @Email(groups = {RegisterUser.class},message = "请输入有效的邮箱地址")
    @Size(groups = {RegisterUser.class},max = 100, message = "邮箱长度不能超过100")
    private String email;

    /**
     * 用户的头像链接，用于存储用户头像的 URL 地址。
     */
    private String avatar;

    /**
     * 用户的角色，用于区分用户在系统中的不同权限。
     */
    @NotBlank(groups = {LoginUser.class},message = "角色不能为空")
    private String role;

    /**
     * 用户注册系统的日期。
     */
    private String regDate;

    /**
     * 用户最后登录系统的时间。
     */
    private String lastLogin;

    /**
     * 用户账号的状态，例如可用、禁用等。
     */
    private String status;

    private int current;
    private int size;
}