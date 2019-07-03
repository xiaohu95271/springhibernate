package com.xiaohu.demo.common;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * 〈一句话功能简述〉<br>
 * 〈MD5工具类〉
 *
 * @author HuTao
 * @create 2019/7/2 16:08
 * @since 1.0.0
 */
public class MD5Utils {

    /**
     * 得到文件的MD5
     * @param file 传入文件
     * @return 返回文件的md5值
     */
    public static String getFileMd5(File file){
        try {
            return DigestUtils.md5DigestAsHex(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到字符串的MD5
     * @param str 传入字符串
     * @return 返回字符串的md5值
     */
    public static String getStringMd5(String str){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update((StringUtil.generateCheckCode(5)+str).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] encode = Hex.encode(md5.digest());
        return new String(encode);
    }
}
