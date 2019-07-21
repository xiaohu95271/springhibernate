package com.xiaohu.demo.service.user.impl;

import com.xiaohu.demo.common.Parameters;
import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import com.xiaohu.demo.domain.repository.base.impl.BaseRepositoryImpl;
import com.xiaohu.demo.domain.user.Role;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.admin.menu.IRoleService;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import com.xiaohu.demo.service.user.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户表==user的service实现方法类〉
 *
 * @author HuTao
 * @create 2019/7/3 17:44
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,String> implements IUserService {

    @Autowired
    private IBaseRepository<User,String> baseRepository;
    @Autowired
    private IRoleService roleService;

    @Override
    public PageBean<User> queryList(User user,Integer page,Integer limit) {
        PageBean<User> bean = new PageBean<>();
        bean.setPage(page);
        bean.setRows(limit);
        PageBean<User> from_user = baseRepository.queryPage(bean, "from User", "", null);
        return from_user;

    }

    @Override
    public void saveTest() {
       baseRepository.save(new User());
    }

    @Override
    public void saveOrUpdateUser(User user, String[] roless) {
        if (StringUtils.isBlank(user.getStatus())){
            user.setStatus("0");
        }
        if (StringUtils.isBlank(user.getHeadimg())){
            user.setHeadimg(Parameters.USER_DEFAULT_HEAD);
        }
        String password = DigestUtils.md5DigestAsHex((user.getPassword() + user.getSalt()).getBytes());
        user.setPassword(password);
        user.setUserCode(String.valueOf(System.currentTimeMillis()));
        //方式二
        Set<Role> set2 = new HashSet<>();
        for (String s : roless) {
            set2.add(roleService.get(s));
        }
        user.setRoles(set2);
        saveOrUpdate(user);
    }

    @Override
    public List<User> queryUser(User user) {
        StringBuilder hql = new StringBuilder(" from User where 1=1 ");
        List<Object> list = new LinkedList<>();
        if (StringUtils.isNotBlank(user.getUserCode())){
            hql.append(" and (userCode=?0 or mobile=?1 )");
            list.add(user.getUserCode());
            list.add(user.getUserCode());
        }

        List<User> query = query(hql.toString(), list.toArray());
        return query;
    }
}
