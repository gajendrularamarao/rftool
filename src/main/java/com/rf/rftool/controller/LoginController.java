package com.rf.rftool.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rf.rftool.dao.ResponsibleDAO;
import com.rf.rftool.dao.UserDAO;
import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;
import com.rf.rftool.service.Userservice;

@Controller
public class LoginController {
	 
	@Autowired
    private Userservice userService;
	@Autowired
	private ResponsibleDAO responsibleDAO; 
	 
	 
	
	
	@RequestMapping(value ="/changepassword",method = RequestMethod.GET)
	public String newRegistration( ModelMap model,HttpSession session) {
		User user1 = (User) session.getAttribute("USER_DETAILS");
		
		model.addAttribute("user",user1);
		return "changepassword";
	}

	
	
	@RequestMapping(value ="/update",method = RequestMethod.POST)
	public String update(ModelMap model , @Valid User user ,HttpSession session) {
		User user1 = (User) session.getAttribute("USER_DETAILS");
		
		System.out.print(user.getUserid());
		
		user1.setUserpass(user.getUserpass());
		User user2 = userService.update(user1);
		
		List<User> list= new ArrayList<User>();;
 	 	list.add(user2);
		model.addAttribute("user",user1);
		model.addAttribute("list",list);  
		 //return new ModelAndView("passwordchanged","list",list);  
		return "passwordchanged";
		
	}
	
	
	@RequestMapping(value ="/excleinsert",method = RequestMethod.GET)
	public String excleinsert( HttpSession session) throws IOException, ParseException {
		User user1 = (User) session.getAttribute("USER_DETAILS");
		//System.out.print(user.getUserid());
		responsibleDAO.getinsertexclesheet();
		return "excelsheet";
	}
	
	
	
}
