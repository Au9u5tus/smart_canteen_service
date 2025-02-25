package com.yuhao.smart_canteen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuhao.smart_canteen.entity.DictionaryEntity;

public interface DictionaryService extends IService<DictionaryEntity> {
    IPage<DictionaryEntity> getDictionaryPage(Page<DictionaryEntity> page);
}
