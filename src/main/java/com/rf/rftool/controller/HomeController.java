package com.rf.rftool.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rf.rftool.model.User;
import com.rf.rftool.service.EscalationService;
import com.rf.rftool.service.StatusService;
import com.rf.rftool.service.Userservice;
import com.rf.rftool.validator.EscalationValidator;
import com.rf.rftool.dao.CategoryDAO;
import com.rf.rftool.dao.DashboardDAO;
import com.rf.rftool.dao.ProjectscopeDAO;
import com.rf.rftool.dao.ResponsibleDAO;
import com.rf.rftool.model.Category;
import com.rf.rftool.model.Dashboard;
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
	    @Autowired
	    private DashboardDAO dashboardDAO;
	    
	
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
    
    Escalations  escalations1 = escalationService.save(escalations ,userSession );
	List<Escalations> list= new ArrayList<Escalations>();;
	 	list.add(escalations1);
    //redirectAttributes.addFlashAttribute("message", "Student " + escalations.getSiteid()+" "+ escalations.getId() + " saved");
	//return "redirect:/viewescalationdetails/"+userSession.getUserid();//will redirect to viewemp request mapping 
	 	model.addAttribute("user",userSession);
	 	return new ModelAndView("escalationsaved", "list",list);
		}
  
  
@RequestMapping(value="/", method = RequestMethod.GET)
public String getHomePage(ModelMap model) {
	LoginForm user = new LoginForm();
	   model.addAttribute("user",user);
		return "index";
	}
  
 @SuppressWarnings("unused")
@RequestMapping(value ="/login",method = RequestMethod.POST)
 public ModelAndView login(@Valid @ModelAttribute("user") LoginForm user, 
				BindingResult bindingResult, ModelMap model,RedirectAttributes redirectAttributes , HttpServletRequest request) {
    
	  if (bindingResult.hasErrors()) {
		  System.out.println("is having errors>>>>>>>>>>>>>>>>");
		  return new ModelAndView("index");
	    }
	 User loginuser = new User();
	 loginuser.setMailid(user.getMailid());
	 loginuser.setUserpass(user.getUserpass());
	 //User user1 = userService.getUser(loginuser);		
    // redirectAttributes.addFlashAttribute("message", "Student " + user.getUserid()+" "+ user.getUsername() + "login...");
	//return "redirect:/viewstudents/1";//will redirect to viewemp request mapping 
     //System.out.println(user1.getUserid());
     //System.out.println(user1.getUsername());
     String tocheckuser="Please Check User ID And Password";
     if(userService.getUser(loginuser)==null)
     {
    	 model.addAttribute("tocheckuser" ,tocheckuser);
    	 return new ModelAndView("index");
     }
     else {	 
    User user1 = userService.getUser(loginuser);	
    System.out.println(user1.getUserid());
    System.out.println(user1.getUsername());
    request.getSession().setAttribute("USER_DETAILS",user1);
    model.addAttribute("user", user1);
    List<Dashboard> dashboard= dashboardDAO.getDashboard(user1);
	 model.addAttribute("dashboard",dashboard);
	if(user1.getUserroll().equalsIgnoreCase("Engineer")){
       return new ModelAndView("userloged");
	   }else {
       return new ModelAndView("adminloged");}
	
    }
     
     
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
 		
    

  @RequestMapping(value="/escalationserach", method = RequestMethod.GET)
  public String escalationserach(ModelMap model , HttpSession session) {
	  
	  User user1 = (User) session.getAttribute("USER_DETAILS");
	  if(user1!=null)
	  {
	  Escalations escalations = new Escalations();
	  List<Status> statuslist= statusService.getStatusList();
	  List<Integer> listids = escalationService.getEscalationIds(user1);
	  model.addAttribute("user",user1);
	  model.addAttribute("escalations", escalations);
	  model.addAttribute("statuslist",statuslist);
	  model.addAttribute("listids",listids);
	  return "escalationsearch";
	  }
	  else
	  {
		  return "index";
	  }
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


@RequestMapping(value="/search", method = RequestMethod.GET)
public String getescalationsearch(ModelMap model  ,@RequestParam("id") int id, @RequestParam("siteid") String siteid ,
		@RequestParam("sitename") String sitename , @RequestParam("startdate") String startdate , @RequestParam("enddate") String enddate , 
		@RequestParam("status") String status ,HttpSession session) {
	
	System.out.println("the ID is >>>>"+id);
	List<Escalations> escalations;
	User user1 = (User) session.getAttribute("USER_DETAILS");
	model.addAttribute("user",user1);
	
	if(id>0)
	{
		escalations = escalationService.getEscalationById(user1, id);
		model.addAttribute("escalations",escalations);
		System.out.println("ID>>>>"+id);
		
	}else {
		
		if( siteid!="" || sitename!="" || startdate!="" || enddate!="" || status!="" )
	     {
		
			System.out.println("ALL Files enter>>>>>>");
			escalations = escalationService.getEscalationBySerach(user1, siteid, sitename, startdate, enddate, status);
			model.addAttribute("escalations",escalations);
		
		System.out.println("siteid>>>>"+siteid);
		System.out.println("sitename>>>"+sitename);
		System.out.println("startdate>>>>"+startdate);
		System.out.println("enddate>>>>"+enddate);
		System.out.println("status>>>>"+status);
		
	      }else {
	    	  System.out.println("kkkkkk");
	    	  escalations = escalationService.getAllEscalations(user1);
	    		model.addAttribute("escalations",escalations);
	    		System.out.println("all feilds are Not nulll>>>>"+id);
	    		
	        }
	}
	return "escalationsearchdetails";
	
	}


@RequestMapping(value="/editescalation/{id}")  
public String edit(@PathVariable int id,ModelMap model ,HttpSession session){  
	User user1 = (User) session.getAttribute("USER_DETAILS");
	List<Escalations> escalations;
	escalations=escalationService.getEscalationById(user1, id);
	
	List<Status> statuslist= statusService.getStatusList();
	List<Category> categoryList = categoryDAO.getCategoryList();
	List<Projectscope> projectscopelist = projectscopeDAO.getProjectscopeList();
	List<Responsible> responsiblelist = responsibleDAO.getResponsibleList();
	
	model.addAttribute("user",user1);
	model.addAttribute("statuslist",statuslist);
	model.addAttribute("categoryList" ,categoryList);
	model.addAttribute("projectscopelist",projectscopelist);
	model.addAttribute("responsiblelist", responsiblelist);
	model.addAttribute("escalations",escalations.get(0));
	return "editescalationfrom";
}
    



@RequestMapping(value="/editscalation" , method = RequestMethod.POST)
public ModelAndView editscalation(@Valid @ModelAttribute("escalations")Escalations escalations,
		BindingResult bindingResult, ModelMap model,RedirectAttributes redirectAttributes,HttpSession session){  
	User user1 = (User) session.getAttribute("USER_DETAILS");
	Escalations escalations1;
	escalations1=escalationService.update(escalations, user1);	
	model.addAttribute("user",user1);
	model.addAttribute("escalations",escalations1);
	List<Escalations> list= new ArrayList<Escalations>();
 	list.add(escalations1);
		
		return new ModelAndView("updatedescalation", "list",list);
}
   

@RequestMapping("/escalationdashform")  

public ModelAndView userdashboard(ModelMap model, HttpSession session){  
	 
	 User user1 = (User) session.getAttribute("USER_DETAILS");
	 model.addAttribute("user",user1);
	 List<Dashboard> dashboard= dashboardDAO.getDashboard(user1);
	 model.addAttribute("dashboard",dashboard);
	 return new ModelAndView("userloged");
   
} 



}


