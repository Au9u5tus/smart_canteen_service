package com.yuhao.canteen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhao.canteen.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}