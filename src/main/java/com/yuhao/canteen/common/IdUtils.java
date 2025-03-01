package com.yuhao.canteen.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class IdUtils {
    public static String generateId(String prefix) {
        StringBuilder id=new StringBuilder(prefix).append(new Date().getTime()).append(String.valueOf(Math.random()).substring(2,5));
        return id.toString();

    }
}
