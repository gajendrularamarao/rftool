package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;

public interface IEscalations {

	public Escalations save(Escalations e , User user);
	public Escalations update(Escalations e , User user);
	public List<Escalations> getAllEscalations(User user);
	public List<Escalations> getAllEscalations();
	public List<Escalations> getEscalationsById(User user , int id);
	public List<Escalations> getEscalationsById(int userid);
	public List<Integer> getEscalationIds(User user);
	public List<Integer> getEscalationIds();
	public List<Escalations> getEscalationBySerach(User user, String siteid, String sitename, String startdate,
			String enddate, String status);
	public List<Escalations> getEscalationBySerach( String siteid, String sitename, String startdate,
			String enddate, String status);
}
