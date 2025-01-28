package com.yuhao.canteen.service;

import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.dto.UserDTO;
import com.yuhao.canteen.entity.UserEntity;

public interface UserService extends CrudService<UserEntity, UserDTO> {

    public Result<String> login(UserDTO userDTO);

}