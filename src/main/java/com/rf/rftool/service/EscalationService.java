package com.rf.rftool.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;
import com.rf.rftool.service.IEscalationservice;
import com.rf.rftool.dao.EscalationsDAO;

@Service
public class EscalationService implements IEscalationservice {
	
	@Autowired
	EscalationsDAO escalationsDAO;

	@Override
	public Escalations save(Escalations e , User user) {
		return escalationsDAO.save(e , user);
	}

	@Override
	public List<User> getAllEscalations() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
