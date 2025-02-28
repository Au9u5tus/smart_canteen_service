package com.yuhao.canteen.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Md5Utils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.dao.UserMapper;
import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Result register(User user) {
        String username = user.getUsername();
        if (StrUtil.isEmpty(username)) {
            return Result.failture("用户名不能为空！");
        }
        String studentId = user.getStudentId();
        if (StrUtil.isEmpty(studentId)) {
            return Result.failture("学号不能为空！");
        }
        String name = user.getName();
        if (StrUtil.isEmpty(name)) {
            return Result.failture("姓名不能为空！");
        }
        String password = user.getPassword();
        if (StrUtil.isEmpty(password)) {
            return Result.failture("密码不能为空！");
        }
        user.setId(IdUtils.generateUserId());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).or().eq("student_id", user.getStudentId());
        long count = count(queryWrapper);
        if (count > 0) {
            return Result.failture("用户名已存在！");
        }
        user.setPassword(Md5Utils.md5WithSalt(password));
        save(user);
        return Result.ok("用户注册成功！");
    }

    @Override
    public Result login(User user) {
        String username = user.getUsername();
        if (StrUtil.isEmpty(username)) {
            return Result.failture("用户名不能为空！");
        }
        String pwd = user.getPassword();
        if (StrUtil.isEmpty(pwd)) {
            return Result.failture("密码不能为空！");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername()).or().eq("student_id", user.getUsername());
        User useInfo = getOne(queryWrapper);
        if (useInfo == null) {
            return Result.failture("用户名或密码错误！");
        }
        String password = useInfo.getPassword();
        if (!password.equals(Md5Utils.md5WithSalt(pwd))) {
            return Result.failture("用户名或密码错误！");
        }
        return Result.ok("登陆成功！");
    }

    public User findUserByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return getOne(queryWrapper);
    }
}
