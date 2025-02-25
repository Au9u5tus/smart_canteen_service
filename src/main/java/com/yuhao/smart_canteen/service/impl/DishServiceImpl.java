package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhao.smart_canteen.dao.DishDao;
import com.yuhao.smart_canteen.dto.DishDTO;
import com.yuhao.smart_canteen.entity.DishEntity;
import com.yuhao.smart_canteen.service.DishService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DishServiceImpl extends CrudServiceImpl<DishDao, DishEntity, DishDTO> implements DishService {

    @Override
    public QueryWrapper<DishEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<DishEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public Page<DishEntity> getDishesByPage(int page, int size) {
        return null;
    }

    @Override
    public DishEntity addDish(DishEntity dish) {
        return null;
    }

    @Override
    public void deleteDish(long id) {

    }

    @Override
    public DishEntity updateDish(DishEntity dishEntity) {
        return null;
    }

    @Override
    public DishEntity getDishById(long id) {
        return null;
    }
}