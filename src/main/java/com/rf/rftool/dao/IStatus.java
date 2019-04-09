package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Status;


public interface IStatus {
	
	public Status save(Status p);
	public List<Status> getStatusList();	
	public void update(Status p);
	public void delete(int id);
	public Status getUser(Status p);

}
