package com.rf.rftool.service;

import java.util.List;

import com.rf.rftool.model.User;
import com.rf.rftool.model.Escalations;

public interface IEscalationservice {
	public Escalations save(Escalations e , User user);
	public List<Escalations> getAllEscalations(User user);	

}
