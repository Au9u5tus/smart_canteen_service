package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.dao.OrdersMapper;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.entity.Orders;
import com.yuhao.canteen.service.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
//    @Override
//    public IPage<Dish> pageQuery(Page<Dish> page, String keyword) {
//        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
//        if (keyword != null && !keyword.isEmpty()) {
//            queryWrapper.like("name", keyword);
//        }
//        return baseMapper.selectPage(page, queryWrapper);
//    }
}