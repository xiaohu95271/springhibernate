package com.xiaohu.demo.service.admin.menu;

import com.xiaohu.demo.common.page.LayuiPageResult;
import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import com.xiaohu.demo.domain.user.Role;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.base.IBaseService;

import java.util.List;

/**
 * @author hu
 */
public interface IRoleService extends IBaseService<Role,String> {

    /**
     * 查询角色列表
     * @param user 用户
     * @param role 角色
     * @return
     */
    LayuiPageResult getPage(User user, Role role);
}
