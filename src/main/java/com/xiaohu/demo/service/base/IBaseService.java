package com.xiaohu.demo.service.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基础方法接口
 * @author hu
 */
public interface  IBaseService<M extends Serializable, PK extends Serializable> {
	Serializable save(M m);

	boolean delete(M m);

	boolean deleteByPK(PK pk);

	boolean deleteByPK(PK[] pk);

	boolean deleteByPK(String hql, PK[] pk);

	boolean deleteByPK(String hql, List<PK> pk);

	boolean deleteAll(Collection<M> m);

	boolean update(M m);

	boolean saveOrUpdate(M m);

	boolean saveOrUpdateAll(Collection<M> m);

	boolean excute(String hql, Object[] params);

	boolean excute(String hql, List<Object> params);
	
	boolean excuteByListParam(String hql, List<?> params);
	
	M load(PK pk);

	M get(PK pk);

	List<M> loadAll();

	List<M> query(String hql, Object[] params);

	List<Object[]> queryArray(String hql, Object[] params);

	List<?> findByNamedParam(String hql, String paramName, Object value);

	List<?> findByNamedParam(String hql, String[] paramNames,
			Object[] values);

	Long count(String hql, Object[] values);
	
	Long countByHql(String hql, Object[] values);
	
	Long countByHql(String hql, Object[] values , Map<String, Object[]> map);

}
