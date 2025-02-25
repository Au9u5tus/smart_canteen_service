package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.smart_canteen.dao.DictionaryDao;
import com.yuhao.smart_canteen.entity.DictionaryEntity;
import com.yuhao.smart_canteen.service.DictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, DictionaryEntity> implements DictionaryService{
    @Override
    public IPage<DictionaryEntity> getDictionaryPage(Page<DictionaryEntity> page) {
        // 调用 MyBatis-Plus 的分页查询方法
        return baseMapper.selectPage(page, null);
    }
}
