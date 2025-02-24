package com.yuhao.smart_canteen.service;


import com.yuhao.smart_canteen.dto.PointsDTO;
import com.yuhao.smart_canteen.entity.PointsEntity;
import com.yuhao.smart_canteen.entity.UserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 *
 * @author David 321740709@qq.com
 * @since 1.0.0 2025-01-27
 */
public interface PointsService extends CrudService<PointsEntity, PointsDTO> {
    Integer getUserPoints(long userId);

    UserEntity addPoints(long userId, double pointsToAdd);

    UserEntity reducePoints( Long userId, int pointsToReduce);
}