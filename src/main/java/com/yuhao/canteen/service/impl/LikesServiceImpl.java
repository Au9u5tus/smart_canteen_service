package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.dao.LikesMapper;
import com.yuhao.canteen.entity.Likes;
import com.yuhao.canteen.service.LikesService;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements LikesService {
}



