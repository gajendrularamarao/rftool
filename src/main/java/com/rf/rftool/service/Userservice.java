package com.rf.rftool.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.rftool.dao.UserDAO;
import com.rf.rftool.model.User;

@Service
public class Userservice implements IUserservice {
	
	@Autowired
    UserDAO userDAO;

	@Override
	public void save(User user) throws SQLException  {
		
		userDAO.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
	   return userDAO.getAllUsers();
	}

	@Override
	public User update(User p) {
		
		return userDAO.update(p);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(User p) {
		
		return userDAO.getUser(p);
	}

	@Override
	public Boolean userExitingChecking(User p) {
		   
		 
		
		 return userDAO.userExitingChecking(p);
	}
	
	
	
}
