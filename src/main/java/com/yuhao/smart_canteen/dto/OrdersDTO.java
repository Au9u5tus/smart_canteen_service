package com.yuhao.smart_canteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(value = "")
public class OrdersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "订单ID")
	private String id;

	@ApiModelProperty(value = "用户ID")
	private String userId;

	@ApiModelProperty(value = "菜品ID")
	private String dishId;

	@ApiModelProperty(value = "菜品的数量")
	private Integer quantity;

	@ApiModelProperty(value = "订单生成时间")
	private String orderTime;

	@ApiModelProperty(value = "订单的总价")
	private Float totalPrice;

	@ApiModelProperty(value = "订单状态")
	private String status;

	@ApiModelProperty(value = "支付方式")
	private String payMethod;

	@ApiModelProperty(value = "送餐地址")
	private String address;

	@ApiModelProperty(value = "预计送餐时间")
	private String delTime;

	@ApiModelProperty(value = "送餐状态")
	private String delStatus;


}