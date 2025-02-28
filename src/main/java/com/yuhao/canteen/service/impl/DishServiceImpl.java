package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.dao.DishMapper;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Override
    public Result<Page<Dish>> findDishInPage(Page<Dish> page, Dish dish) {
        QueryWrapper<Dish> queryWrapper=new QueryWrapper<Dish>();
        if(StringUtils.isNotBlank(dish.getName())){
            queryWrapper.like("name",dish.getName());
        }
        Page<Dish> pageDish=page(page,queryWrapper);
        return Result.ok(pageDish,"²éÑ¯³É¹¦");
    }
}