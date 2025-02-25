package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.dao.OrdersDao;
import com.yuhao.smart_canteen.dto.OrdersDTO;
import com.yuhao.smart_canteen.entity.OrdersEntity;
import com.yuhao.smart_canteen.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersServiceImpl extends CrudServiceImpl<OrdersDao, OrdersEntity, OrdersDTO> implements OrdersService {

    @Override
    public QueryWrapper<OrdersEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrdersEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public OrdersEntity createOrder(long userId, double totalPrice) {
        return null;
    }

    @Override
    public List<OrdersEntity> getAllOrders() {
        return null;
    }

    @Override
    public Optional<OrdersEntity> getOrderById(long id) {
        return Optional.empty();
    }

    @Override
    public OrdersEntity updateOrderStatus(long id, String status) {
        return null;
    }

    @Override
    public void deleteOrder(long id) {

    }
}