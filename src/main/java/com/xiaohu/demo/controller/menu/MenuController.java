package com.xiaohu.demo.controller.menu;

import com.xiaohu.demo.common.menu.MenuResultUtil;
import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import com.xiaohu.demo.domain.user.User;
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
 * @author 13220
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
        Menu menu = menuService.get(id);
        Menu menu1 = null;
        if (StringUtils.isNotBlank(menu.getPid())){
            menu1 = menuService.get(menu.getPid());
        }else {
            menu1 = new Menu();
            menu1.setName("系统根目录");
        }
        modelAndView.addObject("name",menu1.getName());
        modelAndView.addObject("menu",menu);
        return modelAndView;
    }


    /**
     * 返回菜单的数据
     * @return
     */
    @RequestMapping("/menuData")
    @ResponseBody
    public  List<MenuResult> menuData(){
        List<Menu> menus = menuService.getData(new User());
        List<MenuResult> menuResults = MenuResultUtil.menuResults(menus, "", null);
        return menuResults;
    }

    /**
     * 菜单添加
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public  Menu add(Menu menu){
        if (StringUtils.isBlank(menu.getName())){
            menu.setName("未命名");
        }
        Menu id = menuService.saveMenu(menu);
        return id;
    }


    /**
     * 菜单更新
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public  Object update(MenuResult result){
        Menu menu = menuService.updateMenu(result);
        return menu;
    }

    /**
     * 菜单更新
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public  Object del(String id){
        boolean menu = menuService.delMenuById(id);
        return menu;
    }

}
