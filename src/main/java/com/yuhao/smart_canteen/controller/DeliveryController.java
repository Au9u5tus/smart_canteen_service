package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.entity.OrdersEntity;
import com.yuhao.smart_canteen.entity.UserEntity;
import com.yuhao.smart_canteen.service.DeliveryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("takeout/delivery")
@Api(tags="")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    // 分配配送员给订单
    @GetMapping("/assign/{orderId}")
    public OrdersEntity assignDeliveryman(@PathVariable Long orderId) {
        return deliveryService.assignDeliveryman(orderId);
    }
    // 更新订单配送状态
    @GetMapping("/status/{orderId}")
    public OrdersEntity updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        return deliveryService.updateOrderStatus(orderId, status);
    }
    // 获取所有配送员
    @GetMapping("/deliverymen")
    public Iterable<UserEntity> getAllDeliverymen() {
        return deliveryService.getAllDeliverymen();
    }

}