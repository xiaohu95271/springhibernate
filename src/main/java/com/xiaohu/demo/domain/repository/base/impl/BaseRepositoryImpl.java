package com.xiaohu.demo.domain.repository.base.impl;

import com.xiaohu.demo.common.page.PageBean;
import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import com.xiaohu.demo.domain.repository.common.Judge;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;

/**
 * 基础实体类
 * @author hu
 */
@Repository("baseRepository")
public class BaseRepositoryImpl<M extends Serializable, PK extends Serializable> extends HibernateDaoSupport implements IBaseRepository<M, PK> {

//	Logger logger = LoggerFactory.getLogger(BaseRepositoryImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public Session getGenericSession() {
		return getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(M m) {
		return (PK) super.getHibernateTemplate().save(m);
	}

	@Override
	public void delete(M m) throws Exception {
		super.getHibernateTemplate().delete(m);
	}

	@Override
	public void deleteByPK(Class<M> classes, PK pk) throws Exception {
		this.delete(this.get(classes, pk));
	}

	@Override
	public void deleteByPK(Class<M> classes, PK[] pk) throws Exception {
		if (pk != null && pk.length > 0) {
			for (int i = 0; i < pk.length; i++) {
				this.delete(this.get(classes, pk[i]));
			}
		}
	}

	@Override
	public boolean deleteByPK(String hql, PK[] pk) {
		List<PK> pks = Arrays.asList(pk);
		return deleteByPK(hql, pks);
	}

	@Override
	public boolean deleteByPK(String hql, List<PK> pk) {
		Query query = this.getGenericSession().createQuery(hql);

		query.setParameterList("pk", pk);

		return query.executeUpdate() > 0;
	}

	@Override
	public void deleteAll(Collection<M> m) throws Exception {
		super.getHibernateTemplate().deleteAll(m);
	}

	@Override
	public void saveOrUpdate(M m) {
		super.getHibernateTemplate().saveOrUpdate(m);
	}


	@Override
	public boolean excute(String hql, Object[] params) {
		return super.getHibernateTemplate().bulkUpdate(hql, params) > 0;
	}

	@Override
	public boolean excute(String hql, List<Object> params) {
		return super.getHibernateTemplate().bulkUpdate(hql, params.toArray()) > 0;
	}

	@Override
	public boolean excuteByListParam(String hql, List<?> params) {
		Query query = this.getGenericSession().createQuery(hql);

		query.setParameterList("pk", params);

		return query.executeUpdate() > 0;
	}

	@Override
	public M load(Class<M> classes, PK pk) {
		return (M) super.getHibernateTemplate().load(classes, pk);
	}

	@Override
	public M get(Class<M> classes, PK pk) {
		return (M) getHibernateTemplate().get(classes, pk);
	}

	@Override
	public List<M> loadAll(Class<M> classes) {
		return (List<M>) getHibernateTemplate().loadAll(classes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> query(String hql, Object[] params) {
		return (List<M>) super.getHibernateTemplate().find(hql, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> queryArray(String hql, Object[] params) {
		return (List<Object[]>) super.getHibernateTemplate().find(hql, params);
	}

	@Override
	public Long count(String hql, Object[] values) {
		hql = " select count(id) " + hql;

		Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery(query, values);

		return Long.parseLong(query.uniqueResult().toString());
	}

	/*****************************************************************
	 * sql 统计总数
	 * 
	 * @param sql
	 * @param values
	 */
	@Override
	@SuppressWarnings("deprecation")
	public Long countBySql(String sql, Object[] values) {

		Long rowSum = 0L;
		try {			
			rowSum = this.jdbcTemplate.queryForObject(sql,values,java.lang.Long.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowSum == null ? 0 : rowSum;

	}
	
	
	@Override
	public Long countByHQL(String hql, Object[] values,
			Map<String, Object[]> map) {
		Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery(query, values);

		Set<String> set = map.keySet();
		if (!Judge.isEmpty(set)) {
			for (String str : set) {
				query.setParameterList(str, map.get(str));
			}
		}
		return Long.parseLong(query.uniqueResult().toString());
	}

	@Override
	public Long countByHQL(String hql, Object[] values) {
		Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery(query, values);
		return Long.parseLong(query.uniqueResult() != null ? query
				.uniqueResult().toString() : "0");
	}

	@Override
	public Long countByHQL(String hql) {
		Query query = this.getGenericSession().createQuery(hql);
		return Long.parseLong(query.uniqueResult().toString());
	}

//	/*****************************************************************
//	 * 常用分页
//	 *
//	 * @author laizhengyu
//	 * @param hql
//	 * @param values
//	 * @param orderBy
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public PageBean<M> queryPage(String hql, String orderBy, Object[] values) {
//
//		PageBean<M> bean = new PageBean<M>();
//		bean.setPage(PageUtil.getPageNo());
//		bean.setRows(PageUtil.getPageSize());
//
//		Long count = count(hql, values);
//		bean.setAllCount(count);
//
//		if (!Judge.isEmpty(orderBy)) {
//			hql += orderBy;
//		}
//
//		Query query = this.getGenericSession().createQuery(hql);
//		wrapperQuery(query, values);
//		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//		query.setMaxResults(bean.getRows());
//
//		bean.setResult(query.list());
//
//		return bean;
//	}

	/*****************************************************************
	 * 执行sql
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	@Override
	public int excuteBySql(String sql, Object[] params) {

		printLog(sql, params);
		return this.jdbcTemplate.update(sql, params);
	}
	
	
	/*****************************************************************
	 * 手动控制事务：
	 * 		手动提交
	 * @return
	 */
	@Override
	@SuppressWarnings("deprecation")
	public int excuteBySqlByManualTransaction(String sql,Object[] values) {
		
		int returnValue = 0;
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			printLog(sql, values);

			NativeQuery sqlQuery = session.createSQLQuery(sql);

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					sqlQuery.setParameter(i, values[i]);
				}
			}
			
			returnValue = sqlQuery.executeUpdate();
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if(session != null && session.isOpen()) {
				SessionFactoryUtils.closeSession(session);
			}
		}
		return returnValue;
	}
	

	/*****************************************************************
	 * 获取指定范围内的信息列表
	 * 
	 * @param hql
	 * @param values
	 * @param minNum
	 * @param maxNums
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<M> findLimtList(String hql, Object[] values, int minNum,
			int maxNums) {

		Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery(query, values);
		query.setFirstResult(minNum);
		query.setMaxResults(maxNums);

		return query.list();
	}

	/*****************************************************************
	 * 获取指定范围内的信息列表
	 * 
	 * @param sql
	 * @param values
	 * @param minNum
	 * @param maxNums
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findLimtListBySql(String sql,
													   Object[] values, int minNum, int maxNums) {

		String pageSql = this.toMysqlPageSql(sql, maxNums, minNum);

		return this.jdbcTemplate.queryForList(pageSql);
	}

//	/*****************************************************************
//	 * sql分页
//	 *
//	 * @param sql
//	 * @param values
//	 * @return
//	 */
//	public PageBean<Map<String, Object>> queryPageBySql(String sql,
//			Object[] values) {
//
//		// 在这里从PageUtil里面来拿pageNo,pageSize
//		PageBean<Map<String, Object>> bean = new PageBean<Map<String, Object>>();
//		bean.setPage(PageUtil.getPageNo());
//		bean.setRows(PageUtil.getPageSize());
//
//		Long countTotal = this.getCountBySql(sql, values);
//		bean.setAllCount(countTotal);
//
//		String pageSql = this.toMysqlPageSql(sql, bean.getRows(),
//				(bean.getPage() - 1) * bean.getRows());
//		bean.setResult(this.jdbcTemplate.queryForList(pageSql, values));
//
//		return bean;
//	}

	/*****************************************************************
	 * 查找信息
	 * 
	 * @param sql sql
	 * @param values 参数
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findListBySql(String sql, Object[] values) {

		printLog(sql, values);
		return this.jdbcTemplate.queryForList(sql, values);
	}
	
	/*****************************************************************
	 * 查找信息
	 * 
	 * @param sql
	 * @param values
	 * @return
	 */
	@Override
	public Object findListIntegerBySql(String sql, Object[] values) {

		printLog(sql, values);
		return  this.jdbcTemplate.queryForList(sql, values, Object.class);
	}

	@Override
	public PageBean<M> queryPage(PageBean<M> bean, String hql, String orderBy, Object[] values) {
		Long count = count(hql, values);
		bean.setAllCount(count);

		if (!Judge.isEmpty(orderBy)) {
			hql += orderBy;
		}
		org.hibernate.Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery((Query) query, values);
		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
		query.setMaxResults(bean.getRows());

		bean.setResult(query.list());
		return bean;
	}


	/*****************************************************************
	 * 输出日志
	 * @param sql
	 * @param values
	 */
	private void printLog(String sql,Object[] values) {
		
		this.logger.info(sql);
		if(values != null && values.length > 0) {
			for(int i=0; i<values.length; i++) {
				this.logger.info(values[i] != null ? values[i].toString() : null);
			}
		}
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public PageBean<M> queryPage(PageBean<M> bean, String hql, String orderBy,
//			Object[] values) {
//
//		Long count = count(hql, values);
//		bean.setAllCount(count);
//
//		if (!Judge.isEmpty(orderBy)) {
//			hql += orderBy;
//		}
//		Query query = this.getGenericSession().createQuery(hql);
//		wrapperQuery(query, values);
//		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//		query.setMaxResults(bean.getRows());
//
//		bean.setResult(query.list());
//		return bean;
//	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public PageBean<M> queryPage(PageBean<M> bean, String hql, String countHql,
//			String orderBy, Object[] values) {
//		Long count = countByHQL(countHql, values);
//		bean.setAllCount(count);
//		if (count > 0) {
//			if (!Judge.isEmpty(orderBy)) {
//				hql += orderBy;
//			}
//			Query query = this.getGenericSession().createQuery(hql);
//			wrapperQuery(query, values);
//			query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//			query.setMaxResults(bean.getRows());
//
//			bean.setResult(query.list());
//		}
//		return bean;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public PageBean<M> queryPageArray(PageBean<M> bean, String hql,
//			String orderBy, Object[] values) {
//
//		Long count = count(hql, values);
//		bean.setAllCount(count);
//
//		if (!Judge.isEmpty(orderBy)) {
//			hql += orderBy;
//		}
//		Query query = this.getGenericSession().createQuery(hql);
//		wrapperQuery(query, values);
//		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//		query.setMaxResults(bean.getRows());
//
//		bean.setResultArray(query.list());
//
//		return bean;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public PageBean<M> queryPageArray(PageBean<M> bean, String hql,
//			String countHql, String orderBy, Object[] values) {
//		Long count = countByHQL(countHql, values);
//		bean.setAllCount(count);
//
//		if (!Judge.isEmpty(orderBy)) {
//			hql += orderBy;
//		}
//		Query query = this.getGenericSession().createQuery(hql);
//		wrapperQuery(query, values);
//		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//		query.setMaxResults(bean.getRows());
//
//		bean.setResultArray(query.list());
//
//		return bean;
//	}

	@Override
	public Query wrapperQuery(Query query, Object[] params) {
		if (query != null && params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query;
	}

	@Override
	public Query wrapperQuery(Query query, List<Object> params) {
		return wrapperQuery(query, params.toArray());
	}

	@Override
	public List<?> findByNamedParam(String hql, String paramName, Object value) {
		return super.getHibernateTemplate().findByNamedParam(hql, paramName, value);
	}

	/*****************************************************************
	 * 查找信息列表
	 * 
	 * @param hql 语句
	 * @param values 参数
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<M> findList(String hql, Object[] values) {

		return (List<M>) this.getHibernateTemplate().find(hql, values);
	}

	@Override
	public List<?> findByNamedParam(String hql, String[] paramNames,
			Object[] values) {
		return super.getHibernateTemplate().findByNamedParam(hql, paramNames,
				values);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> top(String hql, Object[] params, Integer max) {
		Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery(query, params);
		query.setFirstResult(0);
		query.setMaxResults(max);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> topArray(String hql, Object[] params, Integer max) {
		Query query = this.getGenericSession().createQuery(hql);
		wrapperQuery(query, params);
		query.setFirstResult(0);
		query.setMaxResults(max);
		return query.list();
	}

	@Override
	public void update(M m) {
		super.getHibernateTemplate().update(m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> queryByPK(String hql, PK[] pk) {
		Query query = this.getGenericSession().createQuery(hql);

		List<PK> pks = Arrays.asList(pk);

		query.setParameterList("pk", pks);

		return query.list();
	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public PageBean<M> pageNoCountParamForArray(PageBean<M> bean, String hql,
//			String countHql, String orderBy, Object[] values) {
//		Long count = countByHQL(countHql);
//		bean.setAllCount(count);
//
//		if (!Judge.isEmpty(orderBy)) {
//			hql += orderBy;
//		}
//		Query query = this.getGenericSession().createQuery(hql);
//		wrapperQuery(query, values);
//		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//		query.setMaxResults(bean.getRows());
//
//		bean.setResultArray(query.list());
//
//		return bean;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public PageBean<M> pageNoCountParam(PageBean<M> bean, String hql,
//			String countHql, String orderBy, Object[] values) {
//		Long count = countByHQL(countHql);
//		bean.setAllCount(count);
//
//		if (!Judge.isEmpty(orderBy)) {
//			hql += orderBy;
//		}
//		Query query = this.getGenericSession().createQuery(hql);
//		wrapperQuery(query, values);
//		query.setFirstResult((bean.getPage() - 1) * bean.getRows());
//		query.setMaxResults(bean.getRows());
//
//		bean.setResult(query.list());
//
//		return bean;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> queryMax(String hql, int max) {

		return getGenericSession().createQuery(hql).setMaxResults(max).list();
	}

	/*****************************************************************
	 * sql查询获取信息
	 * 
	 * @param sql
	 * @param values
	 * @return
	 */
	@Override
	public Map<String, Object> findMap(String sql, Object[] values) {

		return this.jdbcTemplate.queryForMap(sql, values);
	}

	/*************************************
	 * 获取信息总数
	 * 
	 * @param sql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private Long getCountBySql(String sql, Object[] values) {

		Long rowSum = 0L;
		String count_sql = "select count(*) ROWSUM from (" + sql + ") aa";
		try {
			rowSum = this.jdbcTemplate.queryForObject(count_sql,values,java.lang.Long.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowSum;
	}

	/****************************************************************
	 * mysql 翻页
	 * 
	 * @param querySql sql 语句
	 * @param max 起始
	 * @param min 数量
	 * @return
	 */
	private String toMysqlPageSql(String querySql, int max, int min) {

		String sql = querySql + " LIMIT " + min + "," + max;

		return sql;
	}


	/*****************************************************************
	 * sql查询获取信息
	 * 
	 * @param sql sql语句
	 * @param args 参数
	 * @param clazz 类别
	 * @return
	 */
	@Override
	public Object queryForObject(String sql, Object[] args, Class<?> clazz) {
		return this.jdbcTemplate.queryForObject(sql, args, clazz);
	}

	
	/**
	 * super.getHibernateTemplate().saveOrUpdateAll(m) 被去掉了
	 */
	@Override
	public void saveOrUpdateAll(Collection<M> m) throws Exception {
		if(m != null && m.size() > 0) {
			for(M mm : m) {
				this.save(mm);
			}
		}
	}

	
	/*****************************************************************
	 * 求和
	 * @param sql 语句
	 * @param params 参数
	 * 	字段别名为sum
	 * @return
	 */
	@Override
	public double sum(String sql, Object[] params) {
		
		Map<String, Object> map = this.jdbcTemplate.queryForMap(sql, params);
		if(map != null &&  map.get("sum") != null) {
			return Double.parseDouble(map.get("sum").toString());
		} else {
			return 0;
		}
	}

	@Override
	public void saveTest() {
		Session genericSession = getGenericSession();
		System.out.println(11111);
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
}
