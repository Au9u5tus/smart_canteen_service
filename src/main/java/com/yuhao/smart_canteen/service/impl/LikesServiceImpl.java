package com.yuhao.smart_canteen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yuhao.smart_canteen.common.Result;
import com.yuhao.smart_canteen.dao.LikesDao;
import com.yuhao.smart_canteen.dto.LikesDTO;
import com.yuhao.smart_canteen.entity.LikesEntity;
import com.yuhao.smart_canteen.service.LikesService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author David 321740709@qq.com
 * @since 1.0.0 2025-01-27
 */
@Service
public class LikesServiceImpl extends CrudServiceImpl<LikesDao, LikesEntity, LikesDTO> implements LikesService {

    @Override
    public QueryWrapper<LikesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<LikesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


    @Override
    public Result likeDish(Long userId, Long dishId) {
        return null;
    }

    @Override
    public Result cancelLikeDish(Long userId, Long dishId) {
        return null;
    }

    @Override
    public Result hasLikedDish(Long userId, Long dishId) {
        return null;
    }

    @Override
    public int getDishLikeCount(Long dishId) {
        return 0;
    }
}