package com.yuhao.smart_canteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel(value = "")
public class DeliveryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "配送ID")
	private String id;

	@ApiModelProperty(value = "订单ID")
	private String orderId;

	@ApiModelProperty(value = "配送人员ID")
	private String personId;

	@ApiModelProperty(value = "配送开始时间")
	private String startTime;

	@ApiModelProperty(value = "配送结束时间")
	private String endTime;

	@ApiModelProperty(value = "配送状态")
	private String status;

	@ApiModelProperty(value = "实际送餐地址")
	private String address;


}