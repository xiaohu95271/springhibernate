package com.xiaohu.demo.controller;

import com.xiaohu.demo.common.MD5Utils;
import com.xiaohu.demo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试controller〉
 *
 * @author HuTao
 * @create 2019/7/2 13:24
 * @since 1.0.0
 */
@Controller
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        System.out.println(MD5Utils.getStringMd5("asdasdasd"));
        return "hello world";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}
