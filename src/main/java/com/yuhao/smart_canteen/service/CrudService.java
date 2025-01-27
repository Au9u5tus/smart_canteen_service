package com.yuhao.smart_canteen.service;

import com.yuhao.smart_canteen.page.PageData;

import java.util.List;
import java.util.Map;

public interface  CrudService<T, D> extends BaseService<T> {

    PageData<D> page(Map<String, Object> params);

    List<D> list(Map<String, Object> params);

    D get(Long id);

    void save(D dto);

    void update(D dto);

    void delete(Long[] ids);

    long count(Map<String,Object> params);

}