package com.xiaohu.demo.controller.menu;

import com.xiaohu.demo.common.menu.MenuResultUtil;
import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 菜单控制器
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    /**
     * 菜单列表页面跳转
     *
     * @return
     */
    @RequestMapping("/toMenuPage")
    public ModelAndView toMenuPage() {
        ModelAndView modelAndView = new ModelAndView("system/menu/menu-list");

        return modelAndView;
    }


    /**
     * 菜单列表页面跳转
     *
     * @return
     */
    @RequestMapping("/toMenuEditPage")
    public ModelAndView toMenuEditPage(String id) {
        ModelAndView modelAndView = new ModelAndView("system/menu/menu-edit");
        if (StringUtils.isNotBlank(id)){
           Menu menu = menuService.get(id);
           if (menu == null){
               menu = new Menu();
               menu.setId("");
               menu.setName("系统根目录");
           }
           modelAndView.addObject("menu",menu);
       }else {
            Menu menu =  menu = new Menu();
            menu.setId("");
            menu.setName("系统根目录");
            modelAndView.addObject("menu",menu);
        }
        return modelAndView;
    }


    /**
     * 返回菜单的数据
     * @return
     */
    @RequestMapping("/menuData")
    @ResponseBody
    public  List<MenuResult> menuData(){
        List<Menu> menus = menuService.loadAll();
        return MenuResultUtil.menuResults(menus,null,null);
    }

    /**
     * 菜单添加
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public  String add(Menu menu){
        String id = menuService.saveMenu(menu);
        return id;
    }

}
