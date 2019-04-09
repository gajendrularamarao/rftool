package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Projectscope;

public interface IProjectscope {

	public Projectscope save(Projectscope p);
	public List<Projectscope> getProjectscopeList();	
	public void update(Projectscope p);
	public void delete(int id);
	public Projectscope getProjectscope(Projectscope p);	
	
}
