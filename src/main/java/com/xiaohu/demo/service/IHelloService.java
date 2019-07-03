package com.xiaohu.demo.service;

import com.xiaohu.demo.domain.User;

import java.io.File;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈sd〉
 *
 * @author HuTao
 * @create 2019/7/2 14:04
 * @since 1.0.0
 */
public interface IHelloService {


    /**
     * 得到文件的md5
     * @param file 文件
     * @return 文件的md5
     */
    String getMd5ByFile(File file);

    /**
     * 保存user
     * @param user user对象
     * @return 文件的md5
     */
    Serializable save(User user);

}
