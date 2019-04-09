package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Category;



public interface ICategory {
	public Category save(Category p);
	public List<Category> getCategoryList();	
	public void update(Category p);
	public void delete(int id);
	public Category getUser(Category p);
}
