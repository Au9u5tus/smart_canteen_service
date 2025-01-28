package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.SystemMessage;
import com.yuhao.canteen.dao.UserDao;
import com.yuhao.canteen.dto.UserDTO;
import com.yuhao.canteen.entity.UserEntity;
import com.yuhao.canteen.exception.LoginException;
import com.yuhao.canteen.service.JwtService;
import com.yuhao.canteen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl extends CrudServiceImpl<UserDao, UserEntity, UserDTO> implements UserService {
    @Autowired
    private JwtService jwtService;

    @Override
    public QueryWrapper<UserEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public Result<String> login(UserDTO userDTO) {
        Map<String,Object> params=new HashMap<>();
        String userName=userDTO.getUsername();
        String password=userDTO.getPassword();
        params.put("username",userName);
        params.put("password",password);
        long res=count(params);
        if(res==0){
            throw new LoginException(SystemMessage.NAME_OR_PWD_ERROR.getCode(),SystemMessage.NAME_OR_PWD_ERROR.getMessage());
        }
        String token=jwtService.generateToken(userName);
        return  new Result<String>().ok(token) ;
    }
}