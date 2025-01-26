package com.yuhao.smart_canteen.common;

import java.util.Date;

public class IdUtils {
    public static final String ORDER_PREFIX="ORDER_";

    public static final String ORDER_DETAIL_PREFOX="ORDER_DETAIL_";

    public static String generateOrderId(){
        StringBuilder orderId=new StringBuilder(ORDER_PREFIX).append(new Date().getTime());
        return orderId.toString();
    }
    public static String generateOrderDetailId(){
        StringBuilder orderDetailId=new StringBuilder(ORDER_DETAIL_PREFOX).append(new Date().getTime());
        return orderDetailId.toString();
    }

}
