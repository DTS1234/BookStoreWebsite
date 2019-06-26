package com.bookstore.dao;

import java.util.*;

public interface GenericDAO<T> {
	
	public T create(T t);
	
	public T update(T t);
	
	public T get(Object id);
	
	public void delete(Object id); 
	
	public List<T> listAll(); //returns the collection of entities
	
	public long count(); //returns the total number entities
}
