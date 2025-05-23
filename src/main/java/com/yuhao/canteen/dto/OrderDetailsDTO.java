package com.yuhao.canteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value = "")
public class OrderDetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "订单详情ID")
	private String id;

	@ApiModelProperty(value = "订单ID")
	private String orderId;

	@ApiModelProperty(value = "菜品ID")
	private String dishId;

	@ApiModelProperty(value = "菜品订单中的数量")
	private Integer quantity;

	@ApiModelProperty(value = "该菜品的单价")
	private Float unitPrice;

	@ApiModelProperty(value = "该菜品的小计金额")
	private Float subTotal;


}