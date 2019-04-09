package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Responsible;



public interface IResponsible {

	public Responsible save(Responsible p);
	public List<Responsible> getResponsibleList();	
	public void update(Responsible p);
	public void delete(int id);
	public Responsible getResponsible(Responsible p);		
	
}
