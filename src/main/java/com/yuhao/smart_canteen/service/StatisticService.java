package com.yuhao.smart_canteen.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StatisticService {
    List<Integer> getOrderCountByDateRange(Date startDate, Date endDate);
    Map<Long, Integer> getDishTypeSales();

    Map<Long, Integer> getDishSales();

    Map<String,Double> staticticByTypes();
}
