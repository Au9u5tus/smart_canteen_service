package com.yuhao.smart_canteen.controller;

import com.yuhao.smart_canteen.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("statistic")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
    //按照菜品数量，订单数量，订单总额
    @GetMapping("/staticticByTypes")
    public Map<String,Double> staticticByTypes(){
        return statisticService.staticticByTypes();
    }
    // 统计指定时间段内的订单数量
    @GetMapping("/orderCount")
    public List<Integer> getOrderCount(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                       @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return statisticService.getOrderCountByDateRange(startDate, endDate);
    }
    // 统计菜品种类的销量
    @GetMapping("/dishTypeSales")
    public Map<Long, Integer> getDishTypeSales() {
        return statisticService.getDishTypeSales();
    }
    // 统计每道菜品的销量
    @GetMapping("/dishSales")
    public Map<Long, Integer> getDishSales() {
        return statisticService.getDishSales();
    }
}
