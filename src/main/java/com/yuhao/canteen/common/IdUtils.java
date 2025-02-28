package com.yuhao.canteen.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IdUtils {

    public static final String USER_PREFIX="USER_";

    public static final String ORDER_PREFIX="ORDER_";

    public static final String ORDER_DETAIL_PREFOX="ORDER_DETAIL_";

    public static final String FILE_PREFIX="FILE_";

    public static String generateUserId() {
        StringBuilder userId=new StringBuilder(USER_PREFIX).append(new Date().getTime());
        return userId.toString();

    }

    public static String generateOrderId(){
        StringBuilder orderId=new StringBuilder(ORDER_PREFIX).append(new Date().getTime());
        return orderId.toString();
    }
    public static String generateOrderDetailId(){
        StringBuilder orderDetailId=new StringBuilder(ORDER_DETAIL_PREFOX).append(new Date().getTime());
        return orderDetailId.toString();
    }
    public static String generateFileId(){
        StringBuilder fileId=new StringBuilder(FILE_PREFIX).append(new Date().getTime());
        return fileId.toString();
    }



}
