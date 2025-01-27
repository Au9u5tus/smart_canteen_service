package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.dao.SystemDictionaryDao;
import com.yuhao.smart_canteen.dto.SystemDictionaryDTO;
import com.yuhao.smart_canteen.entity.SystemDictionaryEntity;
import com.yuhao.smart_canteen.service.SystemDictionaryService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SystemDictionaryServiceImpl extends CrudServiceImpl<SystemDictionaryDao, SystemDictionaryEntity, SystemDictionaryDTO> implements SystemDictionaryService {

    @Override
    public QueryWrapper<SystemDictionaryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SystemDictionaryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}