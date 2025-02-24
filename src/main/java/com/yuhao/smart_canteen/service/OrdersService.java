package com.yuhao.smart_canteen.service;

import com.yuhao.smart_canteen.dto.OrdersDTO;
import com.yuhao.smart_canteen.entity.OrdersEntity;

import java.util.List;
import java.util.Optional;

/**
 * 
 *
 * @author David 321740709@qq.com
 * @since 1.0.0 2025-01-27
 */
public interface OrdersService extends CrudService<OrdersEntity, OrdersDTO> {
    OrdersEntity createOrder(long userId, double totalPrice);

    List<OrdersEntity> getAllOrders();

    Optional<OrdersEntity> getOrderById(long id);

    OrdersEntity updateOrderStatus(long id, String status);

    void deleteOrder(long id);
}