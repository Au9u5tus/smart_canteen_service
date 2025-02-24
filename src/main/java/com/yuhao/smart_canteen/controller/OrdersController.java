package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.entity.OrdersEntity;
import com.yuhao.smart_canteen.service.OrdersService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("orders")
@Api(tags="")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    // 获取所有订单
    @GetMapping
    public List<OrdersEntity> getAllOrders() {
        return ordersService.getAllOrders();
    }
    // 根据 ID 获取订单
    @GetMapping("/{id}")
    public Optional<OrdersEntity> getOrderById(@PathVariable Long id) {
        return ordersService.getOrderById(id);
    }
    // 更新订单状态
    @PutMapping("/{id}/status")
    public OrdersEntity  updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return ordersService.updateOrderStatus(id, status);
    }
    // 删除订单
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersService.deleteOrder(id);
    }

    // 创建订单
    @PostMapping("createOrder")
    public OrdersEntity createOrder(@RequestParam Long userId, @RequestParam double totalPrice) {
        return ordersService.createOrder(userId, totalPrice);
    }


}