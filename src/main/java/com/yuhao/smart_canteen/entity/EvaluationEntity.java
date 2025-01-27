package com.yuhao.smart_canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("evaluation")
public class EvaluationEntity {

    /**
     * 评价ID
     */
	private String id;
    /**
     * 菜品ID
     */
	private String dishId;
    /**
     * 用户ID
     */
	private String userId;
    /**
     * 评分
     */
	private Integer rating;
    /**
     * 用户的评论内容
     */
	private String comment;
    /**
     * 评价时间
     */
	private String evalTime;
}