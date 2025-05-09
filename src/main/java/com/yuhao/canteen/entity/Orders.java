package com.yuhao.canteen.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("orders")
public class Orders {

    /**
     * 订单ID
     */
    @TableId
	private String id;
    /**
     * 用户ID
     */
	private String userId;
    /**
     * 菜品ID
     */
	//private String dishId;
    /**
     * 菜品的数量
     */
	private Integer quantity;
    /**
     * 订单生成时间
     */
	private String orderTime;
    /**
     * 订单的总价
     */
	private Float totalPrice;
    /**
     * 订单状态
     */
	private String status;
    /**
     * 支付方式
     */
	private String payMethod;
    /**
     * 送餐地址
     */
	private String address;
    /**
     * 预计送餐时间
     */
	private String delTime;
    /**
     * 送餐状态
     */
	private String delStatus;

    @TableField(exist = false)
    private String keyword;
    @TableField(exist = false)
    private long current;
    @TableField(exist = false)
    private long size;
    @TableField(exist = false)
    private List<String> detailsId;
}