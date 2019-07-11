package com.xiaohu.demo.common.menu;

import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class MenuResultUtil {

    /**
     * 菜单返回数据封装
     * @param menus 数据集合
     * @param pid 父级id
     * @param base 循环实体
     * @return
     */
    public static List<MenuResult> menuResults(List<Menu> menus,String pid, MenuResult base){
        List<MenuResult> results = new LinkedList<>();
        for (Menu menu : menus) {
            MenuResult menuResult = new MenuResult();
            if (StringUtils.equals(menu.getPid(),pid)){
                menuResult.setId(menu.getId());
                menuResult.setHref(menu.getHref());
                menuResult.setTitle(menu.getName());
                results.add(menuResult);
                menuResults(menus,menu.getId(),menuResult);
            }
        }
        if (base != null){
            base.setChildren(results);
        }
        return results;
    }

}
