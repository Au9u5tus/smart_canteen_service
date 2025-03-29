package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.User;

public interface UserService extends IService<User> {
    Result register(User user);
    Result<String> login(User user);
    User findUserByUserName(String username);
    User findUserByUserId(String userId);
    User getCurrentUser();
    Result<Page<User>> pageQueryDish(User user);
    Result updateUser(User user);
    Result deleteUser(Integer id);
}
