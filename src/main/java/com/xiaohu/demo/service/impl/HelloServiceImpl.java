package com.xiaohu.demo.service.impl;

import com.xiaohu.demo.domain.User;
import com.xiaohu.demo.service.IHelloService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈sd〉
 *
 * @author HuTao
 * @create 2019/7/2 14:04
 * @since 1.0.0
 */
@Service("helloService")
public class HelloServiceImpl extends HibernateDaoSupport implements IHelloService {
    @Autowired(required = false)
    public void setSqlSessionFactory(@Qualifier("sessionFactory") SessionFactory sqlSessionFactory) {
        super.setSessionFactory(sqlSessionFactory);
    }

    @Override
    public String getMd5ByFile(File file) {
        try {
            return DigestUtils.md5DigestAsHex(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Serializable save(User user) {
        return super.getHibernateTemplate().save(user);
    }

}
