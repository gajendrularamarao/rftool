package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;

public interface IEscalations {

	public Escalations save(Escalations e , User user);
	public List<Escalations> getAllEscalations(User user);
}
