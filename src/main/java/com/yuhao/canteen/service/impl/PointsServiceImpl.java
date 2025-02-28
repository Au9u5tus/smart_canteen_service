package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.dao.PointsMapper;
import com.yuhao.canteen.entity.Points;
import com.yuhao.canteen.service.PointsService;
import org.springframework.stereotype.Service;

@Service
public class PointsServiceImpl extends ServiceImpl<PointsMapper, Points> implements PointsService {
}
