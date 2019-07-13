package com.xiaohu.demo.domain.repository.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * @author 13220
 */
public class Judge {
	public static boolean isEmpty(String source) {
		if (source != null && !"".equals(source.trim())) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(Collection<? extends Serializable> col) {
		if (col != null && col.size() > 0) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(Object[] array) {
		if (array != null && array.length > 0) {
			return false;
		}
		return true;
	}

	public static boolean isEmpty(String... array) {
		boolean flag = false;
		for (int i = 0; i < array.length; i++) {
			if (isEmpty(array[i])) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static boolean isEmpty(Object obj) {
		return obj == null;
	}

	public static boolean isEmpty(Map<?, ?> map) {
		if (map != null && map.size() > 0) {
			return false;
		}
		return true;
	}
}
