package com.rf.rftool.service;

import java.util.List;

import com.rf.rftool.model.User;
import com.rf.rftool.model.Escalations;

public interface IEscalationservice {
	public Escalations save(Escalations e , User user);
	public Escalations update(Escalations e , User user);
	public List<Escalations> getAllEscalations(User user);
	public List<Escalations> getEscalationById(User user,int id);
	public List<Integer> getEscalationIds(User user);
	public List<Escalations> getEscalationBySerach( User user , String siteid , String sitename , String startdate , String enddate , String status);

}
