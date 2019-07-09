package com.xiaohu.demo.test;

import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * 〈一句话功能简述〉<br>
 * 〈hql测试〉
 *
 * @author HuTao
 * @create 2019/7/5 12:52
 * @since 1.0.0
 */
public class HQLSeclect extends HibernateDaoSupport {

}
