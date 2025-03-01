package com.yuhao.canteen.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dish")
public class Dish {

    /**
     * 菜单唯一标识符，作为主键
     */
    @TableId
	private String id;
    /**
     * 菜单名称
     */
	private String name;
    /**
     * 菜单描述
     */
	private String description;
    /**
     * 菜品价格
     */
	private Float price;
    /**
     * 菜品分类
     */
	private String category;
    /**
     * 菜品主图的 URL
     */
	private String imageUrl;
    /**
     * 菜品是否可用
     */
	private Integer available;
    /**
     * 菜品创建日期
     */
	private String createDate;
    /**
     * 菜品更新日期
     */
	private String updateDate;

    @TableField(exist = false)
    private String keyword;
    @TableField(exist = false)
    private long current;
    @TableField(exist = false)
    private long size;
}