package com.yuhao.canteen.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuhao.canteen.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    //按照当天销售菜品数量，订单数量，订单总额统计
    @Select("SELECT SUM(od.quantity) AS total_dish_quantity, COUNT(DISTINCT o.id) AS order_count, " +
            "SUM(o.total_price) AS total_order_amount FROM orders o " +
            "JOIN order_details od ON o.id = od.order_id WHERE DATE(o.order_time) = #{date}")
    Map<String, Object> statisticsByDay(@Param("date") String date);
    //统计一段时间内每天的各类菜品销售数量
    @Select("SELECT DATE(o.order_time) AS order_date, d.category, SUM(od.quantity) AS dish_quantity FROM orders o " +
            "JOIN order_details od ON o.id = od.order_id JOIN dish d ON od.dish_id = d.id " +
            "WHERE DATE(o.order_time) BETWEEN #{startDate} AND #{endDate} " +
            "GROUP BY DATE(o.order_time), d.category " +
            "ORDER BY DATE(o.order_time)")
    List<Map<String, Object>> statisticsDishSalesByPeriod(@Param("startDate") String startDate,
                                                          @Param("endDate") String endDate);
    //统计各类菜品的销售比重
    @Select("SELECT d.category, SUM(od.quantity) / (SELECT SUM(quantity) FROM order_details) AS ratio " +
            "FROM order_details od JOIN dish d ON od.dish_id = d.id GROUP BY d.category")
    List<Map<String, Object>> statisticsDishCategoryRatio();
    //统计每种菜品的销售比重
    @Select("SELECT d.name, UM(od.quantity) / (SELECT SUM(quantity) FROM order_details) AS ratio " +
            "FROM order_details od JOIN dish d ON od.dish_id = d.id GROUP BY d.id")
    List<Map<String, Object>> statisticsDishRatio();
}