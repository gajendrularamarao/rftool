package com.rf.rftool.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rf.rftool.model.User;
import com.rf.rftool.service.EscalationService;
import com.rf.rftool.service.StatusService;
import com.rf.rftool.service.Userservice;
import com.rf.rftool.validator.EscalationValidator;
import com.rf.rftool.dao.CategoryDAO;
import com.rf.rftool.dao.ProjectscopeDAO;
import com.rf.rftool.dao.ResponsibleDAO;
import com.rf.rftool.model.Category;
import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.LoginForm;
import com.rf.rftool.model.Projectscope;
import com.rf.rftool.model.Responsible;
import com.rf.rftool.model.Status;

@Controller
public class HomeController {
	    @Autowired
		private Userservice userService;
	    @Autowired
	    private EscalationService escalationService;
	    @Autowired
	    private StatusService statusService ;
	    @Autowired
	    private CategoryDAO categoryDAO;
	    @Autowired
	    private  ProjectscopeDAO projectscopeDAO;
	    @Autowired
	    private ResponsibleDAO responsibleDAO;
	    
	
		@RequestMapping(value ="/enroll",method = RequestMethod.GET)
		public String newRegistration(ModelMap model) {
			Escalations escalations = new Escalations();
			model.addAttribute("escalations", escalations);
			return "escalationReg";
		}
	    
  @RequestMapping(value ="/save",method = RequestMethod.POST)
 public ModelAndView saveRegistration(@Valid @ModelAttribute("escalations")Escalations escalations,
				BindingResult bindingResult, ModelMap model,RedirectAttributes redirectAttributes, HttpSession session ,HttpServletRequest request  ) {
	  
	  if (bindingResult.hasErrors()) {
			//return "escalationReg";//will redirect to viewemp request mapping 
		    User user1 = (User) session.getAttribute("USER_DETAILS");
		    List<Status> statuslist= statusService.getStatusList();
			List<Category> categoryList = categoryDAO.getCategoryList();
			List<Projectscope> projectscopelist = projectscopeDAO.getProjectscopeList();
			List<Responsible> responsiblelist = responsibleDAO.getResponsibleList();
			model.addAttribute("user",user1);
			model.addAttribute("statuslist",statuslist);
			model.addAttribute("categoryList" ,categoryList);
			model.addAttribute("projectscopelist",projectscopelist);
			model.addAttribute("responsiblelist", responsiblelist);
			model.addAttribute("escalations", escalations);
			return new ModelAndView("escalationform"); 
	  }
	  
    User userSession=(User)request.getSession().getAttribute("USER_DETAILS");
    System.out.println(">>>>>>>>"+ userSession.getUserid());
	escalationService.save(escalations ,userSession );		
    //redirectAttributes.addFlashAttribute("message", "Student " + escalations.getSiteid()+" "+ escalations.getId() + " saved");
	//return "redirect:/viewescalationdetails/"+userSession.getUserid();//will redirect to viewemp request mapping 
	return new ModelAndView("escalationsaved");
		}
  
  
@RequestMapping(value="/", method = RequestMethod.GET)
public String getHomePage(ModelMap model) {
	LoginForm user = new LoginForm();
	   model.addAttribute("user",user);
		return "index";
	}
  
 @RequestMapping(value ="/login",method = RequestMethod.POST)
 public String login(@Valid @ModelAttribute("user") LoginForm user, 
				BindingResult bindingResult, ModelMap model,RedirectAttributes redirectAttributes , HttpServletRequest request) {
    
	  if (bindingResult.hasErrors()) {
		  System.out.println("is having errors>>>>>>>>>>>>>>>>");
	      return "index";
	    }
	 User loginuser = new User();
	 loginuser.setMailid(user.getMailid());
	 loginuser.setUserpass(user.getUserpass());
	 User user1 = userService.getUser(loginuser);		
    // redirectAttributes.addFlashAttribute("message", "Student " + user.getUserid()+" "+ user.getUsername() + "login...");
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
	  String userExising="Already User Registred";
 	if (result.hasErrors()) {
 				//return "escalationReg";//will redirect to viewemp request mapping  
 				return new ModelAndView("registration"); 
 		}
 	try {
		
 		if(userService.userExitingChecking(user)) {
 			System.out.println("User exiting>>>>....");
 			model.addAttribute("UserExiting" ,userExising);
 			return new ModelAndView("registration");
 		}
 		else
 		{
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
		
	    } catch (SQLIntegrityConstraintViolationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.print("duplicaton User Exception>>>>>>>>"+e);
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.print("duplicaton User Exception>>>>>>>>"+e);
	    }	
 	return new ModelAndView("registration");
  } 
 		
    
  


@RequestMapping(value="/escalationform", method = RequestMethod.GET)
public String getescalationform(ModelMap model , HttpSession session) {
	Escalations escalations = new Escalations();
	User user1 = (User) session.getAttribute("USER_DETAILS");
	List<Status> statuslist= statusService.getStatusList();
	List<Category> categoryList = categoryDAO.getCategoryList();
	List<Projectscope> projectscopelist = projectscopeDAO.getProjectscopeList();
	List<Responsible> responsiblelist = responsibleDAO.getResponsibleList();
	model.addAttribute("user",user1);
	model.addAttribute("statuslist",statuslist);
	model.addAttribute("categoryList" ,categoryList);
	model.addAttribute("projectscopelist",projectscopelist);
	model.addAttribute("responsiblelist", responsiblelist);
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


@RequestMapping(value="/viewescalationdetails", method = RequestMethod.GET)
public String viewescalationdetails(@RequestParam int userid ) {
	
		return "index";
	}



}


