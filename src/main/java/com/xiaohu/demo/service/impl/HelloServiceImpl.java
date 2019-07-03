package com.xiaohu.demo.service.impl;

import com.xiaohu.demo.service.IHelloService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br>
 * 〈sd〉
 *
 * @author HuTao
 * @create 2019/7/2 14:04
 * @since 1.0.0
 */
@Service("helloService")
public class HelloServiceImpl implements IHelloService {


    @Override
    public String getMd5ByFile(File file) {
        try {
             return DigestUtils.md5DigestAsHex(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
