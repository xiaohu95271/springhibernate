package com.xiaohu.demo.service.base.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.xiaohu.demo.domain.repository.base.IBaseRepository;
import com.xiaohu.demo.domain.repository.common.GenericUtils;
import com.xiaohu.demo.service.base.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 基础的实体类的方法接口
 * @param <M> 实体类
 * @param <PK> id类型
 */
@Service("baseService")
public class BaseServiceImpl<M extends Serializable, PK extends Serializable> implements IBaseService<M, PK> {
	@Autowired
	private IBaseRepository<M, PK> baseRepository;

	private Class<M> entity = null;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		entity = GenericUtils.getSuperClassGenricType(this.getClass());
	}

	@Override
	public PK save(M m) {
		return baseRepository.save(m);
	}

	@Override
	public boolean delete(M m) {
		try {
			baseRepository.delete(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByPK(PK pk) {
		try {
			baseRepository.deleteByPK(entity, pk);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByPK(PK[] pk) {
		try {
			baseRepository.deleteByPK(entity, pk);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByPK(String hql, PK[] pk) {
		try {
			baseRepository.deleteByPK(hql, pk);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteByPK(String hql, List<PK> pk) {
		try {
			baseRepository.deleteByPK(hql, pk);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAll(Collection<M> m) {
		try {
			baseRepository.deleteAll(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(M m) {
		try {
			baseRepository.update(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveOrUpdate(M m) {
		try {
			baseRepository.saveOrUpdate(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveOrUpdateAll(Collection<M> m) {
		try {
			baseRepository.saveOrUpdateAll(m);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean excute(String hql, Object[] params) {
		return baseRepository.excute(hql, params);
	}

	@Override
	public boolean excute(String hql, List<Object> params) {
		return baseRepository.excute(hql, params);
	}

	@Override
	public M load(PK pk) {
		return baseRepository.load(entity, pk);
	}

	@Override
	public M get(PK pk) {
		return baseRepository.get(entity, pk);
	}

	@Override
	public List<M> loadAll() {
		return baseRepository.loadAll(entity);
	}

	@Override
	public List<M> query(String hql, Object[] params) {
		return baseRepository.query(hql, params);
	}

	@Override
	public List<Object[]> queryArray(String hql, Object[] params) {
		return baseRepository.queryArray(hql, params);
	}

	@Override
	public List<?> findByNamedParam(String hql, String paramName, Object value) {
		return baseRepository.findByNamedParam(hql, paramName, value);
	}

	@Override
	public List<?> findByNamedParam(String hql, String[] paramNames,
			Object[] values) {
		return baseRepository.findByNamedParam(hql, paramNames, values);
	}

	@Override
	public Long count(String hql, Object[] values) {
		return baseRepository.count(hql, values);
	}

	@Override
	public Long countByHql(String hql, Object[] values) {
		return baseRepository.countByHQL(hql, values);
	}

	@Override
	public Long countByHql(String hql, Object[] values , Map<String, Object[]> map) {
		return baseRepository.countByHQL(hql, values , map);
	}


	@Override
	public boolean excuteByListParam(String hql, List<?> params) {
		return baseRepository.excuteByListParam(hql, params);
	}

}
