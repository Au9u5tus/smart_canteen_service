package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.dao.DeliveryDao;
import com.yuhao.smart_canteen.dto.DeliveryDTO;
import com.yuhao.smart_canteen.entity.DeliveryEntity;
import com.yuhao.smart_canteen.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class DeliveryServiceImpl extends CrudServiceImpl<DeliveryDao, DeliveryEntity, DeliveryDTO> implements DeliveryService {

    @Override
    public QueryWrapper<DeliveryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<DeliveryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}