package com.yuhao.smart_canteen.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhao.smart_canteen.entity.DishEntity;
import com.yuhao.smart_canteen.service.DishService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("dish")
@Api(tags="")
public class DishController {
    @Autowired
    private DishService dishService;
    //查询菜品
    @GetMapping("getDishes")
    public Page<DishEntity> getDishes(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return dishService.getDishesByPage(page, size);
    }
    // 添加菜品
    @PostMapping("/addDish")
    public DishEntity addDish(@RequestBody DishEntity dish) {
        return dishService.addDish(dish);
    }
    // 删除菜品
    @DeleteMapping("/deleteDish/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
    // 修改菜品信息
    @PostMapping("/updateDish")
    public DishEntity updateDish(@RequestBody DishEntity dish) {
        return dishService.updateDish(dish);
    }
    // 根据 ID 查询菜品
    @GetMapping("getDishById/{id}")
    public DishEntity getDishById(@PathVariable Long id) {
        return dishService.getDishById(id);
    }

}