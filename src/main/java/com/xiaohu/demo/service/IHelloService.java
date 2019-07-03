package com.xiaohu.demo.service;

import java.io.File;

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

}
