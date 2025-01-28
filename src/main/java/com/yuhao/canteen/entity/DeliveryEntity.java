package com.yuhao.canteen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("delivery")
public class DeliveryEntity {

    /**
     * 配送ID
     */
	private String id;
    /**
     * 订单ID
     */
	private String orderId;
    /**
     * 配送人员ID
     */
	private String personId;
    /**
     * 配送开始时间
     */
	private String startTime;
    /**
     * 配送结束时间
     */
	private String endTime;
    /**
     * 配送状态
     */
	private String status;
    /**
     * 实际送餐地址
     */
	private String address;
}