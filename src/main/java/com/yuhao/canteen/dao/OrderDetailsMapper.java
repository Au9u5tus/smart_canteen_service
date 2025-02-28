package com.yuhao.canteen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhao.canteen.entity.OrderDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailsMapper extends BaseMapper<OrderDetails> {
}