package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.dao.DeliveryMapper;
import com.yuhao.canteen.entity.Delivery;
import com.yuhao.canteen.service.DeliveryService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements DeliveryService {
}