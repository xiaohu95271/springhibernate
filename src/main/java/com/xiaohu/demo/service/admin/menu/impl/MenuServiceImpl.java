package com.xiaohu.demo.service.admin.menu.impl;

import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 菜单service
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu,String> implements IMenuService {
    @Override
    public String saveMenu(Menu menu) {
        saveOrUpdate(menu);
        return menu.getId();
    }
}
