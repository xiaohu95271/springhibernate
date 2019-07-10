package com.xiaohu.demo.controller;

import com.xiaohu.demo.common.MD5Utils;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public User hello(){
        User user = new User();
        user.setCompanyId("1");
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        user.setCreateDate(format);
        user.setLastLoginTime(format);
        userService.save(user);
        System.out.println(MD5Utils.getStringMd5("asdasdasd"));
        return user;
    }
    @RequestMapping("/index")
    public String index(){

        return "index";
    }


}
