package com.rf.rftool.service;

import java.util.List;

import com.rf.rftool.model.User;

public interface IUserservice {
	
	
	public void save(User user);
	public List<User> getAllUsers();	
	public void update(User p);
	public void delete(int id);
	public User getUser(User p);

}
