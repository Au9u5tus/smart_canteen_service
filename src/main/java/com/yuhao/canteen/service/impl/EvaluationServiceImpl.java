package com.yuhao.canteen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuhao.canteen.dao.EvaluationMapper;
import com.yuhao.canteen.entity.Evaluation;
import com.yuhao.canteen.service.EvaluationService;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements EvaluationService {
}
