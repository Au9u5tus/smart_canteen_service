package com.yuhao.smart_canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("dish")
public class DishEntity {

    /**
     * 菜单唯一标识符，作为主键
     */
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
	private String imageUrlFirst;
    /**
     * 菜品的第二张图
     */
	private String imageUrlSecond;
    /**
     * 菜品的第三张图
     */
	private String imageUrlThird;
    /**
     * 菜品的第四张图
     */
	private String imageUrlForth;
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
}