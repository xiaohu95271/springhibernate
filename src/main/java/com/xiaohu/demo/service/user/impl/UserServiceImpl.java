package com.xiaohu.demo.service.user.impl;

import com.xiaohu.demo.domain.User;
import com.xiaohu.demo.service.base.impl.BaseServiceImpl;
import com.xiaohu.demo.service.user.IuserService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户表==user的service实现方法类〉
 *
 * @author HuTao
 * @create 2019/7/3 17:44
 * @since 1.0.0
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,String> implements IuserService {
}
