package com.xiaohu.demo.service.admin.menu;

import com.xiaohu.demo.common.page.LayuiPageResult;
import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.user.Role;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.base.IBaseService;

/**
 * @author hu
 */
public interface IRoleService extends IBaseService<Role,String> {

    /**
     * 查询角色列表
     * @param user 用户
     * @param role 角色
     * @param bean 分页
     * @return
     */
    LayuiPageResult getPage(User user, Role role, PageBean<Role> bean);

    /**
     * 添加角色
     * @param role 角色实体
     * @param menuId 菜单id
     * @param user 用户实体
     */
    void saveRole(Role role, String[] menuId, User user);
}
