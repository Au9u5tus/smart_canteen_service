package com.yuhao.canteen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "")
public class EvaluationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "评价ID")
	private String id;

	@ApiModelProperty(value = "菜品ID")
	private String dishId;

	@ApiModelProperty(value = "用户ID")
	private String userId;

	@ApiModelProperty(value = "评分")
	private Integer rating;

	@ApiModelProperty(value = "用户的评论内容")
	private String comment;

	@ApiModelProperty(value = "评价时间")
	private String evalTime;


}