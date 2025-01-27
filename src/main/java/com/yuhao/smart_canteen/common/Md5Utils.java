package com.yuhao.smart_canteen.common;

import com.yuhao.smart_canteen.constant.Constant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static String md5WithSalt(String input) {
        try {
            // 将输入字符串和盐值拼接
            String inputWithSalt = input + Constant.SPECIAL_STR;

            // 获取 MD5 算法的 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 将拼接后的字符串转换为字节数组并进行哈希计算
            byte[] digest = md.digest(inputWithSalt.getBytes());

            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
