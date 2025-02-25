package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.dao.SystemDictionaryDao;
import com.yuhao.smart_canteen.dto.SystemDictionaryDTO;
import com.yuhao.smart_canteen.entity.DictionaryEntity;
import com.yuhao.smart_canteen.service.SystemDictionaryService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SystemDictionaryServiceImpl extends CrudServiceImpl<SystemDictionaryDao, DictionaryEntity, SystemDictionaryDTO> implements SystemDictionaryService {

    @Override
    public QueryWrapper<DictionaryEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<DictionaryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}