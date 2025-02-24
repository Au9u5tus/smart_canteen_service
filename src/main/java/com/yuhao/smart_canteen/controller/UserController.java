package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.constant.Constant;
import com.yuhao.smart_canteen.dto.UserDTO;
import com.yuhao.smart_canteen.entity.*;
import com.yuhao.smart_canteen.page.PageData;
import com.yuhao.smart_canteen.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("user")
@Api(tags="")
public class UserController {
    @Autowired
    private UserService userService;
    // 创建用户
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }
    // 根据 ID 获取用户
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    // 获取所有用户
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
    // 更新用户信息
    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }
    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}