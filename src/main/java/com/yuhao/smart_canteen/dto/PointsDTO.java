package com.yuhao.smart_canteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 *
 * @author David 321740709@qq.com
 * @since 1.0.0 2025-01-27
 */
@Data
@ApiModel(value = "")
public class PointsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "积分ID")
	private String id;

	@ApiModelProperty(value = "用户ID")
	private String userId;

	@ApiModelProperty(value = "积分数量")
	private Integer amount;

	@ApiModelProperty(value = "积分交易类型")
	private String type;

	@ApiModelProperty(value = "积分交易时间")
	private String time;

	@ApiModelProperty(value = "订单ID")
	private Integer orderId;


}