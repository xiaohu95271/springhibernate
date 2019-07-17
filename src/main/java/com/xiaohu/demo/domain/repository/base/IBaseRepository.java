package com.xiaohu.demo.domain.repository.base;

import com.xiaohu.demo.common.page.PageBean;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IBaseRepository<M extends Serializable, PK extends Serializable> {
	public PK save(M m);

	public void delete(M m) throws Exception;

	public void deleteByPK(Class<M> classes, PK pk) throws Exception;

	public void deleteByPK(Class<M> classes, PK[] pk) throws Exception;

	public boolean deleteByPK(String hql, PK[] pk) throws Exception;

	public boolean deleteByPK(String hql, List<PK> pk) throws Exception;

	public void deleteAll(Collection<M> m) throws Exception;

	public void update(M m);

	public void saveOrUpdate(M m) throws Exception;

	public void saveOrUpdateAll(Collection<M> m) throws Exception;

	public boolean excute(String hql, Object[] params);
	
	/*****************************************************************
	 * 手动控制事务：
	 * 		手动提交
	 * @return
	 */
	public int excuteBySqlByManualTransaction(String sql,Object[] values);

	/*****************************************************************
	 * 获取指定范围内的信息列表
	 * 
	 * @param hql
	 * @param values
	 * @param minNum
	 * @param maxNums
	 * @return
	 */
	public List<M> findLimtList(String hql, Object[] values, int minNum,
			int maxNums);

	/*****************************************************************
	 * 获取指定范围内的信息列表
	 * 
	 * @param sql
	 * @param values
	 * @param minNum
	 * @param maxNums
	 * @return
	 */
	public List<Map<String, Object>> findLimtListBySql(String sql, Object[] values, int minNum, int maxNums);

	/*****************************************************************
	 * 执行sql
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int excuteBySql(String sql, Object[] params);

	public boolean excute(String hql, List<Object> params);

	public boolean excuteByListParam(String hql, List<?> params);

	public M load(Class<M> classes, PK pk);

	public M get(Class<M> classes, PK pk);

	public List<M> loadAll(Class<M> classes);

	public List<M> query(String hql, Object[] params);

	public List<M> queryByPK(String hql, PK[] pk);

	public List<Object[]> queryArray(String hql, Object[] params);

	public List<?> findByNamedParam(String hql, String paramName, Object value);

	public List<?> findByNamedParam(String hql, String[] paramNames,
			Object[] values);

	public Long count(String hql, Object[] values);

	public Long countByHQL(String hql);

	public Long countByHQL(String hql, Object[] values);

	public Long countByHQL(String hql, Object[] values,
			Map<String, Object[]> map);

	public Long countBySql(String sql, Object[] values);

	/*****************************************************************
	 * 查找信息列表
	 * 
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<M> findList(String hql, Object[] values);
//
	/*****************************************************************
	 * 常用分页
	 *
	 * @author laizhengyu
	 * @param hql
	 * @param values
	 * @param orderBy
	 * @return
	 */
	public PageBean<M> queryPage(String hql, String orderBy, Object[] values);

	/*****************************************************************
	 * sql分页
	 *
	 * @param sql
	 * @param values
	 * @return
	 */
	public PageBean<Map<String, Object>> queryPageBySql(String sql,
			Object[] values);

	/*****************************************************************
	 * 查找信息
	 * 
	 * @param sql
	 * @param values
	 * @return
	 */
	
	
	public List<Map<String, Object>> findListBySql(String sql, Object[] values);
	
	public Object findListIntegerBySql(String sql, Object[] values);
	

	public PageBean<M> queryPage(PageBean<M> bean, String hql, String orderBy,
								 Object[] values);
//
	public PageBean<M> queryPage(PageBean<M> bean, String hql, String countHql,
			String orderBy, Object[] values);

	public PageBean<M> pageNoCountParam(PageBean<M> bean, String hql,
			String countHql, String orderBy, Object[] values);

	public PageBean<M> pageNoCountParamForArray(PageBean<M> bean, String hql,
			String countHql, String orderBy, Object[] values);

	public PageBean<M> queryPageArray(PageBean<M> bean, String hql,
			String orderBy, Object[] values);

	public PageBean<M> queryPageArray(PageBean<M> bean, String hql,
			String countHql, String orderBy, Object[] values);

	public Query wrapperQuery(Query query, Object[] params);

	public Query wrapperQuery(Query query, List<Object> params);

	public List<M> top(String hql, Object[] params, Integer max);

	public List<Object[]> topArray(String hql, Object[] params, Integer max);

	public List<M> queryMax(String hql, int max);

	/*****************************************************************
	 * sql查询获取信息
	 * 
	 * @param sql sql语句
	 * @param values 参数
	 * @return
	 */
	public Map<String, Object> findMap(String sql, Object[] values);


	public Object queryForObject(String sql, Object[] args, Class<?> clazz);
	
	/*****************************************************************
	 * 求和
	 * @param sql sql语句
	 * @param params 参数
	 * 	字段别名为sum
	 * @return
	 */
	public double sum(String sql,Object[] params);

	void saveRole(String menuId,String roleId);
}