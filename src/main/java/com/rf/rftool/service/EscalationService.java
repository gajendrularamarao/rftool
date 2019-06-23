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
	public List<Escalations> getAllEscalations(User user1) {
		// TODO Auto-generated method stub
		return escalationsDAO.getAllEscalations(user1);
	}

	@Override
	public List<Escalations> getEscalationById(User user, int id) {
		
		return escalationsDAO.getEscalationsById(user, id);
		
	}

	@Override
	public List<Integer> getEscalationIds(User user) {
		return escalationsDAO.getEscalationIds(user);
	}

	@Override
	public List<Escalations> getEscalationBySerach(User user, String siteid, String sitename, String startdate,
			String enddate, String status) {
		
		return escalationsDAO.getEscalationBySerach(user, siteid, sitename, startdate, enddate, status);
	}

	@Override
	public Escalations update(Escalations e, User user) {
		
		
		
		return escalationsDAO.update(e, user);
	}

	@Override
	public List<Integer> getEscalationIds() {
		
		return escalationsDAO.getEscalationIds();
	}
	

}
