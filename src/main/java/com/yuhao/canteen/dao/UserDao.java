package com.yuhao.canteen.dao;


import com.yuhao.canteen.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	
}