package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.canteen.dao.OrderDetailsDao;
import com.yuhao.canteen.dto.OrderDetailsDTO;
import com.yuhao.canteen.entity.OrderDetailsEntity;
import com.yuhao.canteen.service.OrderDetailsService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author David 321740709@qq.com
 * @since 1.0.0 2025-01-27
 */
@Service
public class OrderDetailsServiceImpl extends CrudServiceImpl<OrderDetailsDao, OrderDetailsEntity, OrderDetailsDTO> implements OrderDetailsService {

    @Override
    public QueryWrapper<OrderDetailsEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<OrderDetailsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}