package com.rf.rftool.dao;

import com.rf.rftool.model.Dashboard;
import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;
import java.util.List;

public interface IDashboard {

	public List<Dashboard> getDashboard (User user);
	public List<Dashboard> getAdminDashboard();
	public List<Dashboard> getDashboardAll();
}
