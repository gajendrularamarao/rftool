package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Technology;



public interface ITechnology {
	
	
	public Technology save(Technology t);
	public List<Technology> getTechnologyList();	
	public void update(Technology t);
	public void delete(int id);
	public Technology getTechnology(Technology t);

}
