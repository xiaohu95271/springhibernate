package com.xiaohu.demo.service.admin.menu;

import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.base.IBaseService;

import java.util.List;

public interface IMenuService extends IBaseService<Menu,String> {
    /**
     * 添加菜单
     * @param menu 添加数据
     * @return
     */
    Menu saveMenu(Menu menu);

    /**
     * 菜单更新操作
     * @param result 更新内容
     * @return
     */
    Menu updateMenu(MenuResult result);

    /**
     * 通过id删除
     * @param id id
     * @return
     */
    boolean delMenuById(String id);

    /**
     * 查询菜单数据
     * @param user 用户
     * @return
     */
    List<Menu> getData(User user);
}
