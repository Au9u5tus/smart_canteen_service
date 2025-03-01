package com.yuhao.canteen.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.common.UserUtils;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.dao.DishMapper;
import com.yuhao.canteen.dao.OrderDetailsMapper;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.entity.OrderDetails;
import com.yuhao.canteen.entity.User;
import com.yuhao.canteen.service.DishService;
import com.yuhao.canteen.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl extends ServiceImpl<OrderDetailsMapper, OrderDetails> implements OrderDetailsService {
    @Autowired
    private DishMapper dishMapper;
    @Override
    //点单接口
    public Result addToTemporaryOrder(Dish dish) {
        try {
            User user=UserUtils.getCurrentUser();
            // 查询菜品单价
            Dish dishInfo = dishMapper.selectById(dish.getId());
            if (dishInfo == null) {
                return Result.failture("菜品不存在");
            }
            int avaliable=dishInfo.getAvailable();
            if(avaliable== Constant.DELETED){
                return Result.failture("菜品已下架！");
            }
            QueryWrapper<OrderDetails> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("dish_id",dish.getId());
            queryWrapper.eq("user_id",user.getId());
            OrderDetails orderDetails=getOne(queryWrapper);
            if(orderDetails==null){
                orderDetails=new OrderDetails();
                orderDetails.setUnitPrice(dish.getPrice());
                orderDetails.setSubTotal(dish.getPrice() * orderDetails.getQuantity());
                save(orderDetails);
            }else{
                orderDetails.setQuantity(orderDetails.getQuantity()+1);
                orderDetails.setUnitPrice(orderDetails.getUnitPrice());
                orderDetails.setSubTotal(orderDetails.getUnitPrice()*orderDetails.getQuantity());
                update(orderDetails,queryWrapper);
            }
        } catch (Exception e) {
//            return Result.fail("添加到临时点单失败: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Result<List<OrderDetails>> getTemporaryOrderDetails(String userId) {
        try {
            QueryWrapper<OrderDetails> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            queryWrapper.isNull("order_id");
            List<OrderDetails> orderDetailsList = list(queryWrapper);
            return Result.ok(orderDetailsList,"查询成功");
        } catch (Exception e) {
            return Result.failture("获取点单详情失败: " + e.getMessage());
        }
    }

    @Override
    public Result removeFromTemporaryOrder(String id) {
        try {
            removeById(id);
            return Result.ok("删除成功！");
        } catch (Exception e) {
            return Result.failture("点单删除失败: " + e.getMessage());
        }
    }

    @Override
    public Result updateFromTemporaryOrder(OrderDetails orderDetails) {
        try {
            updateById(orderDetails);
            return Result.ok("更新成功！");
        } catch (Exception e) {
            return Result.failture("点单更新失败: " + e.getMessage());
        }
    }
}
