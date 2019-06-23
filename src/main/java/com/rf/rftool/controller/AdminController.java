package com.rf.rftool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rf.rftool.dao.CategoryDAO;
import com.rf.rftool.dao.DashboardDAO;
import com.rf.rftool.dao.ProjectscopeDAO;
import com.rf.rftool.dao.ResponsibleDAO;
import com.rf.rftool.dao.TechnologyDAO;
import com.rf.rftool.model.Category;
import com.rf.rftool.model.Dashboard;
import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.Projectscope;
import com.rf.rftool.model.Responsible;
import com.rf.rftool.model.Status;
import com.rf.rftool.model.Technology;
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
	

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private  ProjectscopeDAO projectscopeDAO;
    @Autowired
    private ResponsibleDAO responsibleDAO;
    
    @Autowired
    private TechnologyDAO technologyDAO;
	 
	
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
	public String getescalationsearch(ModelMap model  ,@RequestParam("originator_mail") int originator_mail, @RequestParam("siteid") String siteid ,
			@RequestParam("sitename") String sitename , @RequestParam("startdate") String startdate , @RequestParam("enddate") String enddate , 
			@RequestParam("status") String status ,HttpSession session) {
		
		System.out.println("the ID is >>>>"+originator_mail);
		List<Escalations> escalations;
		User user1 = (User) session.getAttribute("USER_DETAILS");
		model.addAttribute("user",user1);
		
		if(originator_mail>0)
		{
			escalations = escalationService.getEscalationById(originator_mail);
			model.addAttribute("escalations",escalations);
			System.out.println("ID>>>>"+originator_mail);
			
		}else {
			
			if( siteid!="" || sitename!="" || startdate!="" || enddate!="" || status!="" )
		     {
			
				System.out.println("ALL Files enter>>>>>>");
				escalations = escalationService.getEscalationBySerach(siteid, sitename, startdate, enddate, status);
				model.addAttribute("escalations",escalations);
			
			System.out.println("siteid>>>>"+siteid);
			System.out.println("sitename>>>"+sitename);
			System.out.println("startdate>>>>"+startdate);
			System.out.println("enddate>>>>"+enddate);
			System.out.println("status>>>>"+status);
			
		      }else {
		    	  System.out.println("kkkkkk");
		    	  escalations = escalationService.getAllEscalations();
		    	  model.addAttribute("escalations",escalations);
		    		System.out.println("all feilds are Not nulll>>>>"+originator_mail);
		    		
		        }
		}
		return "adminescalationserachdetails";
		
		}
	
	
	@RequestMapping(value="/adminpostescalationform", method = RequestMethod.GET)
	public String getescalationform(ModelMap model , HttpSession session) {
		Escalations escalations = new Escalations();
		User user1 = (User) session.getAttribute("USER_DETAILS");
		List<Status> statuslist= statusService.getStatusList();
		List<Category> categoryList = categoryDAO.getCategoryList();
		List<Projectscope> projectscopelist = projectscopeDAO.getProjectscopeList();
		List<Responsible> responsiblelist = responsibleDAO.getResponsibleList();
		List<Technology>  technologylist = technologyDAO.getTechnologyList();
		model.addAttribute("user",user1);
		model.addAttribute("statuslist",statuslist);
		model.addAttribute("categoryList" ,categoryList);
		model.addAttribute("projectscopelist",projectscopelist);
		model.addAttribute("responsiblelist", responsiblelist);
		model.addAttribute("escalations", escalations);
		model.addAttribute("technologylist", technologylist);
		return "adminpostescalationform";
		}	
	

	
	
	 @RequestMapping(value ="/adminsave",method = RequestMethod.POST)
	 public ModelAndView saveRegistration(@Valid @ModelAttribute("escalations")Escalations escalations,
					BindingResult bindingResult, ModelMap model,RedirectAttributes redirectAttributes, HttpSession session ,HttpServletRequest request  ) {
		  
		  if (bindingResult.hasErrors()) {
				//return "escalationReg";//will redirect to viewemp request mapping 
			    User user1 = (User) session.getAttribute("USER_DETAILS");
			    List<Status> statuslist= statusService.getStatusList();
				List<Category> categoryList = categoryDAO.getCategoryList();
				List<Projectscope> projectscopelist = projectscopeDAO.getProjectscopeList();
				List<Responsible> responsiblelist = responsibleDAO.getResponsibleList();
				List<Technology>  technologylist = technologyDAO.getTechnologyList();
				model.addAttribute("user",user1);
				model.addAttribute("statuslist",statuslist);
				model.addAttribute("categoryList" ,categoryList);
				model.addAttribute("projectscopelist",projectscopelist);
				model.addAttribute("responsiblelist", responsiblelist);
				model.addAttribute("escalations", escalations);
				model.addAttribute("technologylist", technologylist);
				return new ModelAndView("adminpostescalationform"); 
		  }
		  
	    User userSession=(User)request.getSession().getAttribute("USER_DETAILS");
	    System.out.println(">>>>>>>>"+ userSession.getUserid());
	    
	    Escalations  escalations1 = escalationService.save(escalations ,userSession );
		List<Escalations> list= new ArrayList<Escalations>();;
		 	list.add(escalations1);
	    //redirectAttributes.addFlashAttribute("message", "Student " + escalations.getSiteid()+" "+ escalations.getId() + " saved");
		//return "redirect:/viewescalationdetails/"+userSession.getUserid();//will redirect to viewemp request mapping 
		 	model.addAttribute("user",userSession);
		 	return new ModelAndView("adminescalationsaved", "list",list);
			}
	
	
	 	 
	 
	 @RequestMapping(value ="/adminchangepassword",method = RequestMethod.GET)
		public String newRegistration( ModelMap model,HttpSession session) {
			User user1 = (User) session.getAttribute("USER_DETAILS");
			model.addAttribute("user",user1);
			return "adminchangepassword";
		}
 
	 @RequestMapping(value ="/adminpasswordupdate",method = RequestMethod.POST)
		public String update(ModelMap model , User user ,HttpSession session) {
			User user1 = (User) session.getAttribute("USER_DETAILS");
			
			System.out.print(user.getUserid());
			
			user1.setUserpass(user.getUserpass());
			User user2 = userService.update(user1);
			
			List<User> list= new ArrayList<User>();;
	 	 	list.add(user2);
			model.addAttribute("user",user1);
			model.addAttribute("list",list);  
			 //return new ModelAndView("passwordchanged","list",list);  
			return "adminpasswordchange";
			
		}
	 
	 	 
	 
}
