package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.dao.PointsDao;
import com.yuhao.smart_canteen.dto.PointsDTO;
import com.yuhao.smart_canteen.entity.PointsEntity;
import com.yuhao.smart_canteen.service.PointsService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author David 321740709@qq.com
 * @since 1.0.0 2025-01-27
 */
@Service
public class PointsServiceImpl extends CrudServiceImpl<PointsDao, PointsEntity, PointsDTO> implements PointsService {

    @Override
    public QueryWrapper<PointsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<PointsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}