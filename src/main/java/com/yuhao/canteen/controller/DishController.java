package com.yuhao.canteen.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhao.canteen.common.IdUtils;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.Condition;

@RestController
@RequestMapping("dish")
public class DishController {
    @Autowired
    private DishService dishService;
//    //获取菜品ID
//    @GetMapping("getDishId")
//    public Result<String> getDishId() {
//        return Result.ok(IdUtils.generateId(Constant.DISH_PREFIX));
//    }
    // 添加菜品
    @PostMapping("addDish")
    public Result addDish(@RequestBody Dish dish) {
        return  dishService.addDish(dish);
    }
    // 修改菜品
    @PostMapping("updateDish")
    public Result updateDish(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
    }
    // 注销菜品
    @GetMapping("deleteDish/{id}")
    public Result deleteDish(@PathVariable String id) {
        return dishService.deleteDish(id);
    }
    // 菜品分页查询（带关键词搜索）
    @PostMapping("pageQueryDish")
    public Result<Page<Dish>> pageQueryDish(@RequestBody Dish dish) {
        return dishService.pageQueryDish(dish);
    }
}
