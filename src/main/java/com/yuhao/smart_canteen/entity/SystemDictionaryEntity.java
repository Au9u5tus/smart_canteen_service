package com.yuhao.smart_canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("system_dictionary")
public class SystemDictionaryEntity {

    /**
     * 字典的唯一标识符，作为主键
     */
	private Integer dictionaryId;
    /**
     * 字典类型，用于区分不同类型的字典项，如订单状态、支付方式、菜品分类等
     */
	private String dictionaryType;
    /**
     * 字典项的键，唯一标识一个字典项，通常是一个简短的代码或名称
     */
	private String dictionaryKey;
    /**
     * 字典项的值，存储该字典项的具体内容或描述
     */
	private String dictionaryValue;
    /**
     * 显示顺序，用于控制字典项在界面上的显示顺序，数字越小越靠前
     */
	private Integer displayOrder;
    /**
     * 是否启用，用于标记该字典项是否可用，1 表示启用，0 表示禁用
     */
	private Integer isEnabled;
    /**
     * 创建时间，记录字典项的创建时间，默认为当前时间戳
     */
	private Date createdAt;
    /**
     * 更新时间，记录字典项的最后更新时间，每次更新自动更新为当前时间戳
     */
	private Date updatedAt;
}