package com.xiaohu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈首页controller〉
 *
 * @author HuTao
 * @create 2019/7/10 15:13
 * @since 1.0.0
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String toHome(){
        return "home";
    }
}
