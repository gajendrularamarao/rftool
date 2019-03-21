package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.Escalations;

public interface IEscalations {

	public void save(Escalations e);
	public List<Escalations> getAllEscalations();
}
