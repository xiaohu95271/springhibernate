package com.xiaohu.demo.service.admin.menu.impl;

import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 菜单service
 * @author 13220
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu,String> implements IMenuService {
    @Override
    public Menu saveMenu(Menu menu) {
        saveOrUpdate(menu);
        return menu;
    }

    @Override
    public Menu updateMenu(MenuResult result) {
        Menu menu = get(result.getId());
        if (menu == null){
            menu = new Menu();
        }
        menu.setName(result.getTitle());
        saveOrUpdate(menu);
        return menu;
    }

    @Override
    public boolean delMenuById(String id) {
        return deleteByPK(id);
    }

    @Override
    public List<Menu> getData(User user) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Menu ");
        List<Object> params = new LinkedList<>();


        hql.append(" order by orderNumber desc ");
        return  this.query(hql.toString(),params.toArray());
    }

    @Override
    public List<Menu> getByRoleId(String id) {
//        query("")
        return null;
    }
}
