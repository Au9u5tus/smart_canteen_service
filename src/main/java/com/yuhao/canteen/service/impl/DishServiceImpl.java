package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.canteen.dao.DishDao;
import com.yuhao.canteen.dto.DishDTO;
import com.yuhao.canteen.entity.DishEntity;
import com.yuhao.canteen.service.DishService;
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


}