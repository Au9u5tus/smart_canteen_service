package com.yuhao.smart_canteen.service;

import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.dto.UserDTO;
import com.yuhao.smart_canteen.entity.UserEntity;

public interface UserService extends CrudService<UserEntity, UserDTO> {

    public Result<String> login(UserDTO userDTO);

}