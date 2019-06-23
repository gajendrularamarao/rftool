package com.rf.rftool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rf.rftool.dao.DashboardDAO;
import com.rf.rftool.dao.ResponsibleDAO;
import com.rf.rftool.model.Dashboard;
import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.Status;
import com.rf.rftool.model.User;
import com.rf.rftool.service.EscalationService;
import com.rf.rftool.service.StatusService;
import com.rf.rftool.service.Userservice;

@Controller
public class AdminController {

	@Autowired
	private DashboardDAO dashboardDAO; 
	
	@Autowired
	private Userservice userService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private EscalationService escalationService;
	 
	
	@RequestMapping("/admindashform")  
	public ModelAndView userdashboard(ModelMap model, HttpSession session){  
		 
		 User user1 = (User) session.getAttribute("USER_DETAILS");
		 model.addAttribute("user",user1);
		 List<Dashboard> admindashboard= dashboardDAO.getAdminDashboard();
		 model.addAttribute("admindashboard",admindashboard);
		 return new ModelAndView("adminloged");
	   
	} 
	
	
	@RequestMapping("/adminuserdashform")  
	public ModelAndView adminuserdashform(ModelMap model, HttpSession session){  
		 
		 User user1 = (User) session.getAttribute("USER_DETAILS");
		 model.addAttribute("user",user1);
		 List<User> list= userService.getAllUsers();
		 
		 model.addAttribute("list",list);
		 return new ModelAndView("adminuserdashform");
	   
	}
	
	
	
	@RequestMapping("/adminuserdashdetails")  
	public ModelAndView adminuserdashdetails(ModelMap model,User user, HttpSession session){  
		 
		 User user1 = (User) session.getAttribute("USER_DETAILS");
		 model.addAttribute("user",user1);
		 if(!user.getMailid().equalsIgnoreCase("NONE")){
		 user.setUserid(Integer.parseInt(user.getMailid()));
		 List<Dashboard> dashboard= dashboardDAO.getDashboard(user);
		 model.addAttribute("dashboard",dashboard);
		 }
		 else{
			 List<Dashboard> dashboard= dashboardDAO.getDashboardAll();
			 model.addAttribute("dashboard",dashboard);
			 
		 }		 
		 
		 return new ModelAndView("adminuserdashboarddetails");
	   
	}
	

	@RequestMapping("/adminescalationserach")  
	public String adminescalationserach(ModelMap model, @ModelAttribute("escalations")Escalations escalations, HttpSession session){  
		 
		 User user1 = (User) session.getAttribute("USER_DETAILS");
		 model.addAttribute("user",user1);
         List<User> list= userService.getAllUsers();
         List<Status> statuslist= statusService.getStatusList();
   	     List<Integer> listids = escalationService.getEscalationIds();
		 model.addAttribute("list",list);
		 model.addAttribute("statuslist",statuslist);
		 model.addAttribute("listids",listids);
		 return "adminescalationserach";
	}	
	
	@RequestMapping(value="/adminescalationserachdetails", method = RequestMethod.GET)
	public String getescalationsearch(ModelMap model  ,@RequestParam("id") int id, @RequestParam("siteid") String siteid ,
			@RequestParam("sitename") String sitename , @RequestParam("startdate") String startdate , @RequestParam("enddate") String enddate , 
			@RequestParam("status") String status ,HttpSession session) {
		
		System.out.println("the ID is >>>>"+id);
		List<Escalations> escalations;
		User user1 = (User) session.getAttribute("USER_DETAILS");
		model.addAttribute("user",user1);
		
		if(id>0)
		{
			//escalations = escalationService.getEscalationById(user1, id);
			//model.addAttribute("escalations",escalations);
			System.out.println("ID>>>>"+id);
			
		}else {
			
			if( siteid!="" || sitename!="" || startdate!="" || enddate!="" || status!="" )
		     {
			
				System.out.println("ALL Files enter>>>>>>");
				//escalations = escalationService.getEscalationBySerach(user1, siteid, sitename, startdate, enddate, status);
				//model.addAttribute("escalations",escalations);
			
			System.out.println("siteid>>>>"+siteid);
			System.out.println("sitename>>>"+sitename);
			System.out.println("startdate>>>>"+startdate);
			System.out.println("enddate>>>>"+enddate);
			System.out.println("status>>>>"+status);
			
		      }else {
		    	  System.out.println("kkkkkk");
		    	  //escalations = escalationService.getAllEscalations(user1);
		    		//model.addAttribute("escalations",escalations);
		    		System.out.println("all feilds are Not nulll>>>>"+id);
		    		
		        }
		}
		return "escalationsearchdetails";
		
		}
	
	
}
