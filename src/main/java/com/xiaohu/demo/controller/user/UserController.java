package com.xiaohu.demo.controller.user;

import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * @author hu
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
//
//    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
//    public String homePage(ModelMap model) {
//        model.addAttribute("greeting", "Hi, Welcome to mysite");
//        return "welcome";
//    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
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

    /**
     * 登陆验证
     *
     * @return map
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(User user) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("from User where userCode='" + user.getUserCode() + "'");
        List<User> query = userService.query("from User where userCode='" + user.getUserCode() + "'", null);
        if (!query.isEmpty()) {
            map.put("code", 0);
        }
        return map;
    }

    /**
     * 用户列表页面跳转
     *
     * @return map
     */
    @RequestMapping(value = "/userList")
    public ModelAndView userList(User user) {
        ModelAndView view = new ModelAndView();

        userService.saveTest();

        view.setViewName("user/user-list");
        return view;
    }


    /**
     * 用户列表页面跳转
     * @param page 当前页
     * @param limit 显示条数
     * @return map
     */
    @RequestMapping(value = "/userDate")
    @ResponseBody
    public Map<String,Object> userDate(User user,Integer page,Integer limit) {
        Map<String,Object> map = new HashMap<>();
        PageBean<User> list = userService.queryList(user,page,limit);
        map.put("code",0);
        map.put("data",list.getResult());
        map.put("count",list.getAllCount());
        map.put("msg","");
        return map;
    }

    /**
     * 添加用户
     *
     * @param user 用户实体
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public Map addUser(User user) {
        Map<String, Object> map = new HashMap<>();
        userService.save(user);
        map.put("code", 0);
        return map;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/login?logout";
    }

    private String getPrincipal() {
        String userName = null;

        return userName;
    }
}