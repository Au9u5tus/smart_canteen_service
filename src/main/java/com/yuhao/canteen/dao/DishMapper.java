package com.yuhao.canteen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhao.canteen.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}