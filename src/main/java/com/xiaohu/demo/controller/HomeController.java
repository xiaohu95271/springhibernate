package com.xiaohu.demo.controller;

import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/home")
    public ModelAndView toHome(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("menus",menuService.getData(new User()));
        return modelAndView;
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {

        return "redirect:/login?logout";
    }

    /**
     * 登陆页面跳转
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
