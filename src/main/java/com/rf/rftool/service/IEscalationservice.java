package com.rf.rftool.service;

import java.util.List;

import com.rf.rftool.model.User;
import com.rf.rftool.model.Escalations;

public interface IEscalationservice {
	public void save(Escalations e , User user);
	public List<User> getAllEscalations();	

}
