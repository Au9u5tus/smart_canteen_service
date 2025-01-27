package com.yuhao.smart_canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("likes")
public class LikesEntity {

    /**
     * 点赞ID
     */
	private String id;
    /**
     * 用户ID
     */
	private String userId;
    /**
     * 菜单ID
     */
	private String dishId;
    /**
     * 点赞时间
     */
	private String likedTime;
}