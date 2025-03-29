package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.common.UserUtils;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.constant.OrderEnum;
import com.yuhao.canteen.dao.DeliveryMapper;
import com.yuhao.canteen.dao.OrderDetailsMapper;
import com.yuhao.canteen.dao.OrdersMapper;
import com.yuhao.canteen.entity.OrderDetails;
import com.yuhao.canteen.entity.Orders;
import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private DeliveryMapper deliveryMapper;
    //查询订单
    public Result<Page<Orders>> pageQueryOrders(Orders orders){
        Page<Orders> page = new Page<>(orders.getCurrent(), orders.getSize());
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("available", Constant.EXIST);
        if(StringUtils.isNotBlank(orders.getKeyword())){
            queryWrapper.like("id",orders.getKeyword());
        }
        Page<Orders> pageDish=page(page,queryWrapper);
        return Result.ok(pageDish,"订单查询成功！");
    }
    //用户下单
    @Transactional
    public Result createOrders(Orders orders){
        String orderId=IdUtils.generateId(Constant.ORDER_PREFIX);
        orders.setId(orderId);
        //订单状态设置待支付
        orders.setStatus(String.valueOf(OrderEnum.FOR_PAY.getCode()));
        save(orders);
        List<String> detailIds=orders.getDetailsId();
        detailIds.forEach(detailId->{
            OrderDetails orderDetails=new OrderDetails();
            orderDetails.setOrderId(orderId);
            orderDetails.setId(detailId);
            orderDetailsMapper.updateById(orderDetails);
        });
        return Result.ok("订单创建成功");
    }
    //修改订单
    public Result updateOrders(Orders orders){
        updateById(orders);
        return Result.ok("订单更新成功");
    }
    //删除订单
    @Override
    public Result deleteOrders(Orders orders){
        String orderId=orders.getId();
        Orders order=getById(orderId);
        if(!OrderEnum.FINISHED.getCode().equals(order.getStatus())
                &&!OrderEnum.CANCELED.getCode().equals(order.getStatus())){
            return Result.failture("当前订单无法删除!");
        }
        removeById(orderId);
        return Result.ok("订单删除成功！");
    }

    public Result queryMyOrders(Orders orders){
       String userId=orders.getUserId();
       Page<Orders> page = new Page<>(orders.getCurrent(), orders.getSize());
       QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
       if(StringUtils.isNotBlank(userId)){
           queryWrapper.eq("user_id", userId);
       }else{
           User currentUser=UserUtils.getCurrentUser();
           queryWrapper.ne("user_id", currentUser.getId());
           queryWrapper.eq("status", OrderEnum.FOR_DELIVERY.getCode());
       }
       Page<Orders> pageDish=page(page,queryWrapper);
       return Result.ok(pageDish,"配送订单查询成功！");
    }
//    @Override
//    public IPage<Dish> pageQuery(Page<Dish> page, String keyword) {
//        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
//        if (keyword != null && !keyword.isEmpty()) {
//            queryWrapper.like("name", keyword);
//        }
//        return baseMapper.selectPage(page, queryWrapper);
//    }
}