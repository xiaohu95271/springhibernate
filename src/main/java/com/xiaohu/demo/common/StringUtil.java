package com.xiaohu.demo.common;

import java.util.Random;

/**
 * 〈字符串工具类〉<br>
 *
 * @author HuTao
 * @create 2019/7/2 16:16
 * @since 1.0.0
 */
public class StringUtil {

    /**
     * 获取随机数
     * @param len 随机数长度
     * @return 随机数
     */
    public static String generateCheckCode(int len) {

        String str = "1234567890ABCEDFGHIJKMLNOPQRSTUVWXYZ";
        int length = str.length();
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(str.charAt(r.nextInt(length - 1)));
        }
        return sb.toString();
    }

}
