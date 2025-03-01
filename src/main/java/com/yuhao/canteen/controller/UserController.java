package com.yuhao.canteen.controller;

import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.UserService;
import com.yuhao.canteen.validate.LoginUser;
import com.yuhao.canteen.validate.RegisterUser;
import com.yuhao.canteen.validate.UserValidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@Api(value = "用户API", description = "用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<String> register(@Validated(RegisterUser.class) @RequestBody User user, BindingResult bindingResult) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public Result<String> login(@Validated(LoginUser.class)@RequestBody User user) {
        return userService.login(user);
    }
}
