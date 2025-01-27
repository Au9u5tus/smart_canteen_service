package com.yuhao.smart_canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("order_details")
public class OrderDetailsEntity {

    /**
     * 订单详情ID
     */
	private String id;
    /**
     * 订单ID
     */
	private String orderId;
    /**
     * 菜品ID
     */
	private String dishId;
    /**
     * 菜品订单中的数量
     */
	private Integer quantity;
    /**
     * 该菜品的单价
     */
	private Float unitPrice;
    /**
     * 该菜品的小计金额
     */
	private Float subTotal;
}