package com.yuhao.canteen.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Md5Utils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.dao.UserMapper;
import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.JwtService;
import com.yuhao.canteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private JwtService jwtService;


    @Override
    public Result register(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        user.setId(IdUtils.generateId(Constant.USER_PREFIX));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).or().eq("student_id", user.getStudentId());
        long count = count(queryWrapper);
        if (count > 0) {
            return Result.failture("用户名或学号已存在！");
        }
        user.setPassword(Md5Utils.md5WithSalt(password));
        user.setRegDate(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        user.setLastLogin(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        save(user);
        return Result.ok("用户注册成功！");
    }

    @Override
    public Result<String> login(User user) {
        String username = user.getUsername();
        String pwd = user.getPassword();
        String role=user.getRole();
        pwd = Md5Utils.md5WithSalt(pwd);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", pwd);
        queryWrapper.eq("role",role);
        User useInfo = getOne(queryWrapper);
        if (useInfo == null) {
            return Result.failture("用户名或密码错误！");
        }else{
            String token=jwtService.generateToken(username);
            return Result.ok(token,"登录成功！");
        }
    }

    public User findUserByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return getOne(queryWrapper);
    }

    public User getCurrentUser(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 在这里可以使用 request 对象
            String header = request.getHeader("Authorization");

        }
        return null;
    }
}
