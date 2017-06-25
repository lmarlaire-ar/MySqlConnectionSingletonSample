package edu.utn.dao;

import java.util.List;

public interface IDao <U, V, S> {
	
	public int delete(U u);

	public List<U> findAll();

	public U findById(int id);

	public U findByName(S s);
	
	public V insert(U u);

	public V update(U u);
}
