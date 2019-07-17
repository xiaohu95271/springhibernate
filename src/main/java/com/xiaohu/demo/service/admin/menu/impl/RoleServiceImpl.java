package com.xiaohu.demo.service.admin.menu.impl;

import com.xiaohu.demo.common.page.LayuiPageResult;
import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.user.Role;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import com.xiaohu.demo.service.admin.menu.IRoleService;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 角色service
 * @author 13220
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role,String> implements IRoleService {


    @Autowired
    private IBaseRepository baseRepository;
    @Autowired
    private IMenuService menuService;

    @Override
    public LayuiPageResult getPage(User user, Role role, PageBean<Role> bean) {
        List<Object> list = new LinkedList<>();
        PageBean pageBean = this.baseRepository.queryPage(bean, "from Role "," order by createDate desc ",list.toArray());
        LayuiPageResult result = new LayuiPageResult(0, pageBean.getResult(), Long.valueOf(pageBean.getResult().size()));
        return result;
    }

    @Override
    public void saveRole(Role role, String[] menuId, User user) {
//        String save = save(role);
        Set<Menu> menus = new HashSet<>();
        for (String s : menuId) {
//            baseRepository.saveRole(s,save);
            menus.add(menuService.get(s));
//            baseRepository.excuteBySql("insert into common_role_menu value(?,?)",new Object[]{s,save});
        }
        role.setMenus(menus);
        save(role);
    }
}
