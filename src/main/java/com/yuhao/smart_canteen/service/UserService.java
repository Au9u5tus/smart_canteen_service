package com.yuhao.smart_canteen.service;

import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.dto.UserDTO;
import com.yuhao.smart_canteen.entity.CommentEntity;
import com.yuhao.smart_canteen.entity.LikesEntity;
import com.yuhao.smart_canteen.entity.OrdersEntity;
import com.yuhao.smart_canteen.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService extends CrudService<UserEntity, UserDTO> {

    public Result<String> login(UserDTO userDTO);

    UserEntity getUserInfo(long userId);

    List<OrdersEntity>  getMyOrders(long userId);

    List<LikesEntity> getMyFavorites(long userId);

    List<CommentEntity> getMyComments(long userId);

    UserEntity createUser(UserEntity user);

    UserEntity getUserById(Long id);

    List<UserEntity> getAllUsers();

    UserEntity updateUser(UserEntity user);

    void deleteUser(Long id);
}