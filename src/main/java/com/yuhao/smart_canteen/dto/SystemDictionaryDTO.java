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
public class SystemDictionaryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典的唯一标识符，作为主键")
	private Integer dictionaryId;

	@ApiModelProperty(value = "字典类型，用于区分不同类型的字典项，如订单状态、支付方式、菜品分类等")
	private String dictionaryType;

	@ApiModelProperty(value = "字典项的键，唯一标识一个字典项，通常是一个简短的代码或名称")
	private String dictionaryKey;

	@ApiModelProperty(value = "字典项的值，存储该字典项的具体内容或描述")
	private String dictionaryValue;

	@ApiModelProperty(value = "显示顺序，用于控制字典项在界面上的显示顺序，数字越小越靠前")
	private Integer displayOrder;

	@ApiModelProperty(value = "是否启用，用于标记该字典项是否可用，1 表示启用，0 表示禁用")
	private Integer isEnabled;

	@ApiModelProperty(value = "创建时间，记录字典项的创建时间，默认为当前时间戳")
	private Date createdAt;

	@ApiModelProperty(value = "更新时间，记录字典项的最后更新时间，每次更新自动更新为当前时间戳")
	private Date updatedAt;


}