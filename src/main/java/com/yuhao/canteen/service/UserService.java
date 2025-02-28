package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.User;

public interface UserService extends IService<User> {
    Result register(User user);
    Result login(User user);
    User findUserByUserName(String username);
}
