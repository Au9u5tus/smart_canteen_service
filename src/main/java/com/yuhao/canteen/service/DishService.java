package com.yuhao.canteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.entity.Dish;

public interface DishService extends IService<Dish> {
    Result<Page<Dish>> pageQueryDish(Dish dish);
    Result addDish(Dish dish);
    Result updateDish(Dish dish);
    Result deleteDish(String id);
}
