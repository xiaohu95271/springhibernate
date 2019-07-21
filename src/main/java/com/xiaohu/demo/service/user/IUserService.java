package com.xiaohu.demo.service.user;

import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 用户表的service接口
 * @author hu
 */
public interface IUserService extends IBaseService<User,String> {

    /**
     * 查询用户列表
     * @param user 查询参数
     * @return
     */
    PageBean<User> queryList(User user, Integer page, Integer limit);

    void saveTest();

    /**
     * 保存或者修改用户
     * @param user 用户
     * @param roless 角色
     */
    void saveOrUpdateUser(User user, String[] roless);

    /**
     * 查找用户
     * @param user 用户
     * @return
     */
    List<User> queryUser(User user);
}
