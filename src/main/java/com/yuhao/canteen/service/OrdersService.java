package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.entity.Orders;

public interface OrdersService extends IService<Orders> {
    Result createOrders(Orders orders);

    Result updateOrders(Orders orders);

    Result<Page<Orders>> pageQueryOrders(Orders orders);

    Result deleteOrders(Orders orders);

    Result queryMyOrders(Orders orders);
}
