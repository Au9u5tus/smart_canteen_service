package com.yuhao.canteen.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.constant.DeliveryEnum;
import com.yuhao.canteen.constant.OrderEnum;
import com.yuhao.canteen.dao.DeliveryMapper;
import com.yuhao.canteen.dao.OrdersMapper;
import com.yuhao.canteen.entity.Delivery;
import com.yuhao.canteen.entity.Orders;
import com.yuhao.canteen.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {
    @Autowired
    private OrdersMapper ordersMapper;
    //获取待配送订单列表
    public Result<List<Orders>> getPendingOrders() {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",OrderEnum.FOR_DELIVERY.getCode());
        return Result.ok(ordersMapper.selectList(queryWrapper),"查询待分配订单成功！") ;
    }
    //配送员接配送单
    public Result userGetOrder(String orderId, String userId) {
        Delivery delivery=new Delivery();
        delivery.setId(Constant.DELIVERY_PREFIX);
        delivery.setStatus(DeliveryEnum.WILLDELIVERY.getCode());
        delivery.setStartTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        save(delivery);
        Orders order=new Orders();
        order.setId(orderId);
        order.setStatus(OrderEnum.FINISHED.getCode());
        ordersMapper.updateById(order);
        return Result.ok("已接收待配送订单，开始配送");
    }
    //完成订单配送
    public Result completeDelivery(String orderId) {
        Delivery delivery=new Delivery();
        delivery.setId(Constant.DELIVERY_PREFIX);
        delivery.setStatus(DeliveryEnum.DELIVERYED.getCode());
        delivery.setEndTime(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        save(delivery);
        Orders order=new Orders();
        order.setId(orderId);
        order.setStatus(OrderEnum.FINISHED.getCode());
        ordersMapper.updateById(order);
        return Result.ok("完成配送！");
    }
    //获取配送订单列表
    public Result<List<Orders>> getDeliveryOrders() {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("status",OrderEnum.IN_DELIVERY.getCode());
        //queryWrapper.eq("status",OrderEnum.FOR_DELIVERY.getCode());
        return Result.ok(ordersMapper.selectList(queryWrapper),"查询待分配订单成功！") ;
    }
}