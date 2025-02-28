package com.yuhao.canteen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhao.canteen.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
