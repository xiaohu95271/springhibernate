package com.xiaohu.demo.common.shiro;

import com.xiaohu.demo.domain.user.User;
import com.xiaohu.demo.service.user.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hu
 */
@Component
public class UserRealm extends AuthorizingRealm {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(UserRealm.class);


    @Autowired
    private IUserService userService;


    /**
     * 获取授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }


    /**
     * 获取身份验证相关信息：
     *
     * @param authcToken token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        try {
            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            User user = new User();
            user.setUserCode(token.getUsername());
            List<User> list = userService.queryUser(user);
            if (!list.isEmpty()) {
                return new SimpleAuthenticationInfo(list.get(0), list.get(0).getPassword(), "");
            }
            logger.info("登录验证失败，shiro 不添加权限信息");
            return null;
        } catch (Exception e) {
            logger.error("shiro 身份验证异常:", e);
            return null;
        }
    }


}