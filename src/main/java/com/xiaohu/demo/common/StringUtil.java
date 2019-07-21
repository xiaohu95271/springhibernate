package com.xiaohu.demo.common;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

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
    /**
     * 打印出0-num个不重复的随机数
     * @param arr 自己定义任意长度的数组,但必须小于num个,否则会出现很多个0的情况
     * @return 将不重复的随机数赋给数组中的各个元素并返回
     */
    public static String randomArr(int[] arr,int num) {
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
//            arr[i]=rd.nextInt(10)+1;//常规来说是这样.但是我想输出不重复的随机数
            int temp = rd.nextInt(num);//先将随机数赋值给一个中间变量
            //然后再遍历一遍数组,如果有相同的,就不算,并且i--重新随机.
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == temp) {
                    count++;//在外循环定义一个计数器,在内循环内判断是否重复.否则循环结束
                    //内循环中的变量不能用于外循环
                }
            }
            if (count > 0) {//内循环结束,在外循环判断是否计数器>0,如果是,就i--,重新随机.
                //否则赋值给数组
                i--;
            } else {
                arr[i] = temp;
            }
        }
        System.out.println("StringUtils.join(arr) = " + ArrayUtils.toString(arr));
        return StringUtils.join(arr);

    }

    public static void main(String[] args) {
        System.out.println("randomArr(new int[5],16) = " + randomArr(new int[10], 16));
    }
}
