package com.yuhao.smart_canteen.service;


import com.yuhao.smart_canteen.dto.DeliveryDTO;
import com.yuhao.smart_canteen.entity.DeliveryEntity;
import com.yuhao.smart_canteen.entity.OrdersEntity;
import com.yuhao.smart_canteen.entity.UserEntity;


public interface DeliveryService extends CrudService<DeliveryEntity, DeliveryDTO> {

    OrdersEntity assignDeliveryman(Long orderId);

    OrdersEntity updateOrderStatus(long orderId, String status);

    Iterable<UserEntity> getAllDeliverymen();

}