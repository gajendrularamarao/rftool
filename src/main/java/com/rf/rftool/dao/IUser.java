package com.rf.rftool.dao;

import java.sql.SQLException;
import java.util.List;

import com.rf.rftool.model.User;

public interface IUser {
	public User save(User p) throws SQLException;
	public List<User> getAllUsers();	
	public void update(User p);
	public void delete(int id);
	public User getUser(User p);
	public Boolean userExitingChecking(User p);
	
}
