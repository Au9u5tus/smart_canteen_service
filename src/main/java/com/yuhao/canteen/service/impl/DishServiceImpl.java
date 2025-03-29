package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.common.Result;
import com.yuhao.canteen.constant.Constant;
import com.yuhao.canteen.dao.DishMapper;
import com.yuhao.canteen.entity.Dish;
import com.yuhao.canteen.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Override
    public Result<Page<Dish>> pageQueryDish(Dish dish) {
        Page<Dish> page = new Page<>(dish.getCurrent(), dish.getSize());
        QueryWrapper<Dish> queryWrapper=new QueryWrapper<Dish>();
        queryWrapper.eq("available", Constant.EXIST);
        if(StringUtils.isNotBlank(dish.getName())){
            queryWrapper.like("name",dish.getName());
        }
        Page<Dish> pageDish=page(page,queryWrapper);
        return Result.ok(pageDish,"菜品查询成功！");
    }
    //添加菜品
    @Override
    public Result addDish(Dish dish) {
        try{
            save(dish);
            return Result.ok("添加菜品成功！");
        }catch (Exception e){
            log.error("添加菜品异常！",e);
            return Result.failture("添加菜品成功！");
        }
    }
    //更新菜品
    @Override
    public Result updateDish(Dish dish) {
        try{
            updateById(dish);
            return Result.ok("修改菜品成功！");
        }catch (Exception e){
            log.error("修改菜品异常！",e);
            return Result.failture("修改菜品成功！");
        }
    }
    //删除菜品
    @Override
    public Result deleteDish(String id) {
        boolean result = removeById(id);
        try{
            Dish dish=new Dish();
            dish.setAvailable(Constant.DELETED);
            updateById(dish);
            return Result.ok("修改菜品成功！");
        }catch (Exception e){
            log.error("修改菜品异常！",e);
            return Result.failture("修改菜品成功！");
        }
    }
}