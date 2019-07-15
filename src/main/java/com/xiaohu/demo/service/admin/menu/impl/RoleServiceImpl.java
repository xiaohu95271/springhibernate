package com.xiaohu.demo.service.admin.menu.impl;

import com.xiaohu.demo.common.page.LayuiPageResult;
import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import com.xiaohu.demo.domain.system.menu.Menu;
import com.xiaohu.demo.domain.system.menu.MenuResult;
import com.xiaohu.demo.domain.user.Role;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.admin.menu.IMenuService;
import com.xiaohu.demo.service.admin.menu.IRoleService;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 角色service
 * @author 13220
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role,String> implements IRoleService {


    @Autowired
    private IBaseRepository baseRepository;

    @Override
    public LayuiPageResult getPage(User user, Role role) {
        PageBean pageBean = this.baseRepository.queryPage("from Role ", "order by createDate desc ", null);
        LayuiPageResult result = new LayuiPageResult(0, pageBean.getResult(), pageBean.getAllCount());
        return result;
    }
}
