package com.yuhao.smart_canteen.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuhao.smart_canteen.dto.DishDTO;
import com.yuhao.smart_canteen.entity.DishEntity;

public interface DishService extends CrudService<DishEntity, DishDTO> {
 Page<DishEntity> getDishesByPage(int page, int size);

 DishEntity addDish(DishEntity dish);

 void deleteDish(long id);

 DishEntity updateDish(DishEntity dishEntity);

 DishEntity getDishById(long id);
}