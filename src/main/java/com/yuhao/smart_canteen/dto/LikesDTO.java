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
public class LikesDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "点赞ID")
	private String id;

	@ApiModelProperty(value = "用户ID")
	private String userId;

	@ApiModelProperty(value = "菜单ID")
	private String dishId;

	@ApiModelProperty(value = "点赞时间")
	private String likedTime;


}