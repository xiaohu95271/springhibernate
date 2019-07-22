package com.xiaohu.demo.common.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @author hu
 */
@Component
public class UserRealm extends AuthorizingRealm {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(UserRealm.class);

    public final static String CREDENTIALS = "openid";
//
//    @Autowired
//    private SessionService sessionService;
//    @Autowired
//    private PermissionService permissionService;

    // 记录是否已经设置过PemissionResover
    private boolean hasSetPemissionResover = false;

    @Override
    public PermissionResolver getPermissionResolver() {
        if (!hasSetPemissionResover) {
//            setPermissionResolver(new WildcardExtPermissionResolver());
            hasSetPemissionResover = true;
        }
        return super.getPermissionResolver();
    }

    /**
     * 获取授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        try {
            Iterator<String> iter = principals.fromRealm(getName()).iterator();
            if (!iter.hasNext()) {
                logger.info("shiro 验证 无权限");
                return null;
            }
            String email = iter.next();
//            if (!Strings.isNullOrEmpty(email)) {
//                // set session
//                SessionObject so = sessionService.getSession(email);
//                if (so == null) {
//                    logger.info("so 缓存为空");
//                    return null;
//                }
//                SessionUtils.setSo(so);

                // set auth
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//                info.addStringPermissions();
//                return info;
//            }
            logger.info("邮箱为空");
            return null;
        } catch (Exception e) {
            logger.error("shiro 权限获取异常:", e);
            return null;
        }
    }

    /**
     * 获取身份验证相关信息：
     *
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        try {
            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            String email = token.getUsername();
            String password = new String(token.getPassword());
            if (!StringUtils.isEmpty(email) && CREDENTIALS.equals(password)) {
//                SessionObject so = SessionUtils.getSo();
//                sessionService.addOrUpdateSession(so);
                return new SimpleAuthenticationInfo(email, CREDENTIALS, getName());
            }
            logger.info("登录验证失败，shiro 不添加权限信息");
            return null;
        } catch (Exception e) {
            logger.error("shiro 身份验证异常:", e);
            return null;
        }
    }


}