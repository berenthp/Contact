package com.sopra.dao;

import java.util.List;

public interface GenericDAO<T, K> {
	List<T> findAll();
	T findByKey (K id);
	T insert(T obj);
	T update(T obj);
	void deleteByKey(K Key);
}
