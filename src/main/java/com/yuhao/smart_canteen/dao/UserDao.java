package com.yuhao.smart_canteen.dao;


import com.yuhao.smart_canteen.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	
}