package com.rf.rftool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rf.rftool.model.User;
import com.rf.rftool.service.EscalationService;
import com.rf.rftool.service.Userservice;

import com.rf.rftool.model.Escalations;
@Controller
public class HomeController {
	    @Autowired
		private Userservice userService;
	    @Autowired
	    private EscalationService escalationService;
	    
	
		@RequestMapping(value ="/enroll",method = RequestMethod.GET)
		public String newRegistration(ModelMap model) {
			Escalations escalations = new Escalations();
			model.addAttribute("escalations", escalations);
			return "escalationReg";
		}
	    
  @RequestMapping(value ="/save",method = RequestMethod.POST)
 public String saveRegistration(@Valid Escalations escalations,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

	if (result.hasErrors()) {
				return "escalationReg";//will redirect to viewemp request mapping  
		}
	escalationService.save(escalations);		
    redirectAttributes.addFlashAttribute("message", "Student " + escalations.getSiteid()+" "+ escalations.getId() + " saved");
	//return "redirect:/viewstudents/1";//will redirect to viewemp request mapping 
	return "userdetails";
		}
  
  @RequestMapping(value ="/login",method = RequestMethod.POST)
 public String login(@Valid User user,
				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes , HttpServletRequest request) {

	
	 User user1 = userService.getUser(user);		
    redirectAttributes.addFlashAttribute("message", "Student " + user.getUserid()+" "+ user.getUsername() + "login...");
	//return "redirect:/viewstudents/1";//will redirect to viewemp request mapping 
     System.out.println(user1.getUserid());
     System.out.println(user1.getUsername());
     request.getSession().setAttribute("USER_DETAILS",user1);
    model.addAttribute("user", user1);
	return "userloged";
		}
  @RequestMapping(value="/registration", method = RequestMethod.GET)
  public String getRegistration(ModelMap model) {
  	   User user = new User();
  	   model.addAttribute("user",user);
  		return "registration";
  	}  
  
  @SuppressWarnings("null")
@RequestMapping(value ="/regsubmit",method = RequestMethod.POST)
  public ModelAndView saveUserRegistration(@Valid User user,
 				BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {
	  System.out.print("enter User Registration submit");
 	if (result.hasErrors()) {
 				//return "escalationReg";//will redirect to viewemp request mapping  
 				return new ModelAndView("registration"); 
 		}
 	userService.save(user);	
 	User user2 = userService.getUser(user);
 	System.out.print(user2.getUserid());
 	System.out.print(user2.getUsername());
 	 List<User> list= new ArrayList<User>();;
 	 list.add(user2);
    redirectAttributes.addFlashAttribute("message", "User" + user2.getUserid()+" "+ user2.getUsername() + " saved");
 	//return "redirect:/viewstudents/1";//will redirect to viewemp request mapping 
 	return new ModelAndView("usercreated","list",list); 
 		}
    
  
  
@RequestMapping(value="/", method = RequestMethod.GET)
public String getHomePage(ModelMap model) {
	   User user = new User();
	   model.addAttribute("user",user);
		return "index";
	}

@RequestMapping(value="/escalationform", method = RequestMethod.GET)
public String getescalationform(ModelMap model , HttpSession session) {
	Escalations escalations = new Escalations();
	User user1 = (User) session.getAttribute("USER_DETAILS");
	model.addAttribute("user",user1);
	model.addAttribute("escalations", escalations);
	 	return "escalationform";
	}
@RequestMapping("/users")  
public ModelAndView viewstudents(){  
    List<User> list= userService.getAllUsers();
    return new ModelAndView("userdetails","list",list);  
} 

@RequestMapping(value="/logout", method = RequestMethod.GET)
public String logout(ModelMap model , HttpServletRequest request) {
	request.getSession().invalidate();
	   User user = new User();
	   model.addAttribute("user",user);
		return "index";
	} 



}


