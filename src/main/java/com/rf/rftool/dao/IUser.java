package com.rf.rftool.dao;

import java.util.List;

import com.rf.rftool.model.User;

public interface IUser {
	public void save(User p);
	public List<User> getAllUsers();	
	public void update(User p);
	public void delete(int id);
	public User getUser(User p);
	
}
