package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.dao.EvaluationDao;
import com.yuhao.smart_canteen.dto.EvaluationDTO;
import com.yuhao.smart_canteen.entity.EvaluationEntity;
import com.yuhao.smart_canteen.service.EvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EvaluationServiceImpl extends CrudServiceImpl<EvaluationDao, EvaluationEntity, EvaluationDTO> implements EvaluationService {

    @Override
    public QueryWrapper<EvaluationEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<EvaluationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public List<EvaluationEntity> getEvaluationsByDishId(long dishId) {
        return null;
    }

    @Override
    public List<EvaluationEntity> getEvaluationsByUserId(long userId) {
        return null;
    }

    @Override
    public void deleteEvaluation(long id) {

    }

    @Override
    public EvaluationEntity getEvaluationById(long id) {
        return null;
    }
}