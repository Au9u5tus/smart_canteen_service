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
public class DishDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "菜单唯一标识符，作为主键")
	private String id;

	@ApiModelProperty(value = "菜单名称")
	private String name;

	@ApiModelProperty(value = "菜单描述")
	private String description;

	@ApiModelProperty(value = "菜品价格")
	private Float price;

	@ApiModelProperty(value = "菜品分类")
	private String category;

	@ApiModelProperty(value = "菜品主图的 URL")
	private String imageUrlFirst;

	@ApiModelProperty(value = "菜品的第二张图")
	private String imageUrlSecond;

	@ApiModelProperty(value = "菜品的第三张图")
	private String imageUrlThird;

	@ApiModelProperty(value = "菜品的第四张图")
	private String imageUrlForth;

	@ApiModelProperty(value = "菜品是否可用")
	private Integer available;

	@ApiModelProperty(value = "菜品创建日期")
	private String createDate;

	@ApiModelProperty(value = "菜品更新日期")
	private String updateDate;


}