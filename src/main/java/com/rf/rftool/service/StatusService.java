package com.rf.rftool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.rftool.dao.StatusDAO;
import com.rf.rftool.model.Status;

@Service
public class StatusService implements IStatusservice{

	@Autowired
    StatusDAO statusDAO;
	
	@Override
	public void save(Status status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Status> getStatusList() {
		return statusDAO.getStatusList();
		
	}

	@Override
	public void update(Status p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getStatus(Status p) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
