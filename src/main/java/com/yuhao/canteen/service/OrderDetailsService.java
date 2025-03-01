package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService extends IService<OrderDetails> {
    Result addToTemporaryOrder(Dish dish);

    Result<List<OrderDetails>> getTemporaryOrderDetails(String userId);

    Result removeFromTemporaryOrder(String id);

    Result updateFromTemporaryOrder(OrderDetails orderDetails);
}
