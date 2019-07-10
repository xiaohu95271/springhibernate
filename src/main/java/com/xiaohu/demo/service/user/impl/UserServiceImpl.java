package com.xiaohu.demo.service.user.impl;

import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import com.xiaohu.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageBean<User> queryList(User user,Integer page,Integer limit) {
        PageBean<User> bean = new PageBean<>();
        bean.setPage(page);
        bean.setRows(limit);
        PageBean<User> from_user = baseRepository.queryPage(bean, "from User", "", null);
        return from_user;

    }
}
