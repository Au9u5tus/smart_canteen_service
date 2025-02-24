package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.dao.UserDao;
import com.yuhao.smart_canteen.dto.UserDTO;
import com.yuhao.smart_canteen.entity.CommentEntity;
import com.yuhao.smart_canteen.entity.LikesEntity;
import com.yuhao.smart_canteen.entity.OrdersEntity;
import com.yuhao.smart_canteen.entity.UserEntity;
import com.yuhao.smart_canteen.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl extends CrudServiceImpl<UserDao, UserEntity, UserDTO> implements UserService {

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
        params.put("user_name",userDTO.getUsername());
        params.put("password",userDTO.getPassword());
        long res=count(params);
        if(res==0){
            return  new Result<String>().ok("fail");
        }
        return  new Result<String>().ok("success") ;
    }

    public UserEntity getUserInfo(long userId){
        return null;
    }

   public List<OrdersEntity> getMyOrders(long userId){
        return null;
   }

   public List<LikesEntity> getMyFavorites(long userId){
        return null;
    }

    public List<CommentEntity> getMyComments(long userId){
        return null;
    }

    public UserEntity createUser(UserEntity user){
        return null;
    }

    public UserEntity getUserById(Long id){
        return null;
    }

    public List<UserEntity> getAllUsers(){
        return null;
    }

    public UserEntity updateUser(UserEntity user){
        return null;
    }

    public void deleteUser(Long id){
        
    }
}