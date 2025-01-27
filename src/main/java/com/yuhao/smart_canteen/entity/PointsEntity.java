package com.yuhao.smart_canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("points")
public class PointsEntity {

    /**
     * 积分ID
     */
	private String id;
    /**
     * 用户ID
     */
	private String userId;
    /**
     * 积分数量
     */
	private Integer amount;
    /**
     * 积分交易类型
     */
	private String type;
    /**
     * 积分交易时间
     */
	private String time;
    /**
     * 订单ID
     */
	private Integer orderId;
}