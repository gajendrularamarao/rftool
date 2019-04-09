package com.rf.rftool.service;

import java.util.List;

import com.rf.rftool.model.Status;


public interface IStatusservice {

	public void save(Status status);
	public List<Status> getStatusList();	
	public void update(Status p);
	public void delete(int id);
	public Status getStatus(Status p);
}
