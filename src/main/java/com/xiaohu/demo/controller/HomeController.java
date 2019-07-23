package com.xiaohu.demo.controller;

import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            subject.logout();
        }
        try {
            response.sendRedirect(request.getContextPath()+"/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
