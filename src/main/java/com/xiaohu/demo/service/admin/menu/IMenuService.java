package com.xiaohu.demo.service.admin.menu;

import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.service.base.IBaseService;

public interface IMenuService extends IBaseService<Menu,String> {
    /**
     * 添加菜单
     * @param menu 添加数据
     * @return
     */
    String saveMenu(Menu menu);
}
