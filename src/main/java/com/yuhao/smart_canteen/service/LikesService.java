package com.yuhao.smart_canteen.service;


import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.dto.LikesDTO;
import com.yuhao.smart_canteen.entity.LikesEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface LikesService extends CrudService<LikesEntity, LikesDTO> {
    Result likeDish( Long userId,  Long dishId);
    Result cancelLikeDish(Long userId,Long dishId);
    Result hasLikedDish(Long userId,Long dishId);
    int getDishLikeCount(Long dishId);

}