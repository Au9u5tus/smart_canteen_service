package com.yuhao.smart_canteen.service;

import com.yuhao.smart_canteen.dto.EvaluationDTO;
import com.yuhao.smart_canteen.entity.EvaluationEntity;

import java.util.List;

public interface EvaluationService extends CrudService<EvaluationEntity, EvaluationDTO> {

    List<EvaluationEntity> getEvaluationsByDishId(long dishId);

    List<EvaluationEntity> getEvaluationsByUserId(long userId);

    void deleteEvaluation(long id);

    EvaluationEntity getEvaluationById(long id);
}