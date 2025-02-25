package com.yuhao.smart_canteen.service.impl;

import com.yuhao.smart_canteen.service.StatisticService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Override
    public List<Integer> getOrderCountByDateRange(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Map<Long, Integer> getDishTypeSales() {
        return null;
    }

    @Override
    public Map<Long, Integer> getDishSales() {
        return null;
    }

    @Override
    public Map<String, Double> staticticByTypes() {
        return null;
    }
}
