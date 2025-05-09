package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.dao.DictionaryMapper;
import com.yuhao.canteen.entity.Dictionary;
import com.yuhao.canteen.service.DictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {
}
