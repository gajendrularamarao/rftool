package com.rf.rftool.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;


import com.rf.rftool.dao.IEscalations;
import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;

@Service
public class EscalationsDAO implements IEscalations {

	
JdbcTemplate template;  
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	public Escalations save(Escalations e , User user){
			
		String sql="insert into ssaescalation(siteid,\n" + 
				"sitename,\n" + 
				"technology,\n" + 
				"site_status,\n" + 
				"ro_region,\n" + 
				"project_scope,\n" + 
				"startdate,\n" + 
				"status,\n" + 
				"originator_mail,\n" + 
				"responsible,\n" + 
				"category,\n" + 
				"problem_description,\n" + 
				"requested_action_history,\n" + 
				"mail_reference,\n" + 
				"lead_time_in_days,\n" + 
				"userid) values('"+e.getSiteid()+"','"+e.getSitename()+"','"+e.getTechnology()+
				"','"+e.getSite_status()+"','"+e.getRo_region()+"','"+e.getProject_scope()+
				"','"+e.getStartdate()+"','"+e.getStatus()+"','"+e.getOriginator_mail()+
				"','"+e.getResponsible()+"','"+e.getCategory()+"','"+e.getProblem_description()+"','"+e.getRequested_action_history()+"','" +e.getMail_reference()+
				"',"+e.getLead_time_in_days()+","+user.getUserid()+")";
		System.out.println(sql);
	     template.update(sql);  
	     
	     return template.query("SELECT * FROM ssaescalation WHERE id=(SELECT MAX(id) FROM ssaescalation);" ,new ResultSetExtractor<Escalations>(){  
			    
		     public Escalations extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		    	 Escalations escalations= new Escalations();
		        while(rs.next()){  
		       
		         escalations.setSiteid(rs.getString(1));
		         escalations.setSitename(rs.getString(2));
		         escalations.setTechnology(rs.getString(3));
		         escalations.setSite_status(rs.getString(4));
		         escalations.setRo_region(rs.getString(5));
		         escalations.setProject_scope(rs.getString(6));
		         escalations.setStartdate(rs.getString(7));
		         escalations.setEnddate(rs.getString(8));
		         escalations.setStatus(rs.getString(9));
		         escalations.setOriginator_mail(rs.getString(10));
		         escalations.setResponsible(rs.getString(11));
		         escalations.setCategory(rs.getString(12));
		         escalations.setProblem_description(rs.getString(13));
		         escalations.setRequested_action_history(rs.getString(14));
		         escalations.setMail_reference(rs.getString(15));
		         escalations.setLead_time_in_days(rs.getInt(16));
		         escalations.setId(rs.getInt(18));
		        }  
		        return escalations;  
		        }  
		    });  
		
	}

	@Override
	public List<Escalations> getAllEscalations(User user) {
		
		return template.query("select * from ssaescalation where userid="+user.getUserid()+";",new ResultSetExtractor<List<Escalations>>(){  
		    
		     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Escalations> list=new ArrayList<Escalations>();  
		        while(rs.next()){  
		        Escalations e=new Escalations();  
		        e.setSiteid(rs.getString(1));
		        e.setSitename(rs.getString(2));
		        e.setTechnology(rs.getString(3));
		        e.setSite_status(rs.getString(4));
		        e.setRo_region(rs.getString(5));
		        e.setProject_scope(rs.getString(6));
		        e.setStartdate(rs.getString(7));
		        e.setEnddate(rs.getString(8));
		        e.setStatus(rs.getString(9));
		        e.setOriginator_mail(rs.getString(10));
		        e.setResponsible(rs.getString(11));
		        e.setCategory(rs.getString(12));
		        e.setProblem_description(rs.getString(13));
		        e.setRequested_action_history(rs.getString(14));
		        e.setMail_reference(rs.getString(15));
		        
		        if(rs.getString(8)==null) {
		        	System.out.println("......No of Days >>>>>>>>+NULL");
		        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
		        }
		        else
		        {
		        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
		        }
		        
		        
		        
		        e.setId(rs.getInt(18));
		        
		        
		        
		        
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
	}
	
	

	@Override
	public List<Escalations> getEscalationsById(User user,int id) {
		
		String sql ="select * from ssaescalation where userid="+user.getUserid()+" and id="+id+";";
		System.out.println(sql);
		
		return template.query("select * from ssaescalation where userid="+user.getUserid()+" and id="+id+";",new ResultSetExtractor<List<Escalations>>(){  
		    
		     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Escalations> list=new ArrayList<Escalations>();  
		        while(rs.next()){  
		        Escalations e=new Escalations();  
		        e.setSiteid(rs.getString(1));
		        e.setSitename(rs.getString(2));
		        e.setTechnology(rs.getString(3));
		        e.setSite_status(rs.getString(4));
		        e.setRo_region(rs.getString(5));
		        e.setProject_scope(rs.getString(6));
		        e.setStartdate(rs.getString(7));
		        e.setEnddate(rs.getString(8));
		        e.setStatus(rs.getString(9));
		        e.setOriginator_mail(rs.getString(10));
		        e.setResponsible(rs.getString(11));
		        e.setCategory(rs.getString(12));
		        e.setProblem_description(rs.getString(13));
		        e.setRequested_action_history(rs.getString(14));
		        e.setMail_reference(rs.getString(15));
		        
		        if(rs.getString(8)==null) {
		        	System.out.println("......No of Days >>>>>>>>+NULL");
		        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
		        }
		        else
		        {
		        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
		        }
		        e.setId(rs.getInt(18));
		       
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
	}

	@Override
	public List<Integer> getEscalationIds(User user) {
		
		String sql ="select * from ssaescalation where userid="+user.getUserid()+";";
		System.out.println(sql);
		
		return template.query("select id from ssaescalation where userid="+user.getUserid()+";",new ResultSetExtractor<List<Integer>>(){  
		    
		     public List<Integer> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		        List<Integer> list=new ArrayList<Integer>();  
		        while(rs.next()){  
                  list.add(rs.getInt(1));
		        }  
		        return list;  
		        }  
		    });
		
		
	}
	
	 public int getDateDifferences(String startdate )
	   {
		   
		 LocalDate currentdate = LocalDate.now();
		 System.out.println("......No of Days >>>>>>>>   NULLL"+currentdate.now().toString());
		 LocalDate Startdate = LocalDate.parse(startdate);
		 long noOfDaysBetween = ChronoUnit.DAYS.between(Startdate ,currentdate );
		 System.out.println("......No of Days >>>>>>>>   NULLL"+noOfDaysBetween);
		 return (int)noOfDaysBetween;
	   }
	
   public int getDateDifferences(String startdate , String enddate)
   {
	   
	   LocalDate Startdate = LocalDate.parse(startdate);
	   LocalDate Enddate = LocalDate.parse(enddate);
	   long noOfDaysBetween = ChronoUnit.DAYS.between(Startdate ,Enddate );
	   System.out.println("......No of Days >>>>>>>>"+noOfDaysBetween);
	   return (int)noOfDaysBetween;
   }

@Override
public List<Escalations> getEscalationBySerach(User user, String siteid, String sitename, String startdate,
		String enddate, String status) {
	
	 List<Escalations> list=new ArrayList<Escalations>();
	 
	    if(siteid!="" && enddate!="" && startdate!="" && status!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+" and siteid = '"+siteid+"' and  startdate between '"+startdate+"' and '"+enddate+"' and  status='"+status+"';";
	        System.out.println(sql);	
	        list = template.query("select * from ssaescalation where userid="+user.getUserid()+" and siteid ='"+siteid+"' and  startdate between '"+startdate+"' and '"+ enddate +"' and  status='"+status+"' ;",new ResultSetExtractor<List<Escalations>>(){  
	        	List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			         
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        
			        
			        
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    
	    }
	
	    if(sitename!="" && enddate!="" && startdate!="" && status!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+" and sitename ='"+sitename+"' and startdate between '"+startdate+"' and '"+ enddate  +"' and status='"+status+"';";
	    	System.out.println(sql);
	    	list = template.query("select * from ssaescalation where userid="+user.getUserid()+" and sitename ='"+sitename+"' and startdate between '"+startdate+"' and '"+ enddate  +"' and status='"+status+"';",new ResultSetExtractor<List<Escalations>>(){  
	    		 List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    	
	   
	    }
	
	    if(enddate!="" && startdate!="" && status!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+"  and startdate between '"+startdate+"' and '"+ enddate  +"' and status='"+status+"';";
	    	System.out.println(sql);
	    	list = template.query("select * from ssaescalation where userid="+user.getUserid()+"  and startdate between '"+startdate+"' and '"+ enddate  +"' and status='"+status+"';",new ResultSetExtractor<List<Escalations>>(){  
	    		 List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    	
	   
	    }
	    
	    if(enddate!="" && startdate!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+"  and startdate between '"+startdate+"' and '"+ enddate  +"';";
	    	System.out.println(sql);
	    	list = template.query("select * from ssaescalation where userid="+user.getUserid()+"  and startdate between '"+startdate+"' and '"+ enddate  +"';",new ResultSetExtractor<List<Escalations>>(){  
	    		 List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    	
	   
	    }
	    
	    if(status!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+"  and status='"+status+"';";
	    	System.out.println(sql);
	    	list = template.query("select * from ssaescalation where userid="+user.getUserid()+ " and status='"+status+"';",new ResultSetExtractor<List<Escalations>>(){  
	    		 List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    	
	   
	    }
	    if(sitename!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+"  and sitename='"+sitename+"';";
	    	System.out.println(sql);
	    	list = template.query("select * from ssaescalation where userid="+user.getUserid()+ " and sitename='"+sitename+"';",new ResultSetExtractor<List<Escalations>>(){  
	    		 List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    	
	   
	    }
	    
	    
	    if(siteid!="" ) 
	    {
	    	String sql = "select * from ssaescalation where userid="+user.getUserid()+"  and siteid='"+siteid+"';";
	    	System.out.println(sql);
	    	list = template.query("select * from ssaescalation where userid="+user.getUserid()+ " and siteid='"+siteid+"';",new ResultSetExtractor<List<Escalations>>(){  
	    		 List<Escalations> list1=new ArrayList<Escalations>(); 
			     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        
			        while(rs.next()){  
			        Escalations e=new Escalations();  
			        e.setSiteid(rs.getString(1));
			        e.setSitename(rs.getString(2));
			        e.setTechnology(rs.getString(3));
			        e.setSite_status(rs.getString(4));
			        e.setRo_region(rs.getString(5));
			        e.setProject_scope(rs.getString(6));
			        e.setStartdate(rs.getString(7));
			        e.setEnddate(rs.getString(8));
			        e.setStatus(rs.getString(9));
			        e.setOriginator_mail(rs.getString(10));
			        e.setResponsible(rs.getString(11));
			        e.setCategory(rs.getString(12));
			        e.setProblem_description(rs.getString(13));
			        e.setRequested_action_history(rs.getString(14));
			        e.setMail_reference(rs.getString(15));
			        
			        if(rs.getString(8)==null) {
			        	System.out.println("......No of Days >>>>>>>>+NULL");
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
			        }
			        else
			        {
			        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
			        }
			        e.setId(rs.getInt(18));
			        
			        list1.add(e);  
			        }  
			        System.out.print("RECORD Size>>>>>>>"+list1.size());
			        return list1;  
			        }  
			    });  
	    	
	    	
	   
	    }
	    
	return list;
}
/////
@Override
public Escalations update(Escalations e, User user) {
	
	 
	String sql ="UPDATE ssaescalation SET siteid ='"+e.getSiteid() +"', sitename ='"+ e.getSitename()  + "', technology ='"+ e.getTechnology()+"',"
			+ "site_status ='"+ e.getSite_status()+"', ro_region = '"+e.getRo_region()+"', project_scope ='"+ e.getProject_scope()+"', startdate ='"+ e.getStartdate() +
			"', enddate ='"+ e.getEnddate()+"', status ='"+ e.getStatus()  +"', originator_mail = '"+ e.getOriginator_mail() +"', responsible ='"+e.getResponsible() +
			"', category ='"+ e.getCategory()+"', problem_description ='"+ e.getProblem_description()  +"', requested_action_history = '"+e.getRequested_action_history()+
			"', mail_reference ='"+ e.getMail_reference()  +"', lead_time_in_days = "+ getDateDifferences(e.getStartdate() , e.getEnddate())+", userid = "+ user.getUserid()   +"  WHERE id ="+e.getId()+";" ; 
	System.out.println("Update the record >>>>>>"+ sql  );
	template.update(sql);		
	 return template.query("SELECT * FROM ssaescalation WHERE id="+e.getId()+";" ,new ResultSetExtractor<Escalations>(){  
		    
	     public Escalations extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	    	 Escalations escalations= new Escalations();
	        while(rs.next()){  
	       
	         escalations.setSiteid(rs.getString(1));
	         escalations.setSitename(rs.getString(2));
	         escalations.setTechnology(rs.getString(3));
	         escalations.setSite_status(rs.getString(4));
	         escalations.setRo_region(rs.getString(5));
	         escalations.setProject_scope(rs.getString(6));
	         escalations.setStartdate(rs.getString(7));
	         escalations.setEnddate(rs.getString(8));
	         escalations.setStatus(rs.getString(9));
	         escalations.setOriginator_mail(rs.getString(10));
	         escalations.setResponsible(rs.getString(11));
	         escalations.setCategory(rs.getString(12));
	         escalations.setProblem_description(rs.getString(13));
	         escalations.setRequested_action_history(rs.getString(14));
	         escalations.setMail_reference(rs.getString(15));
	         escalations.setLead_time_in_days(rs.getInt(16));
	         escalations.setId(rs.getInt(18));
	        }  
	        return escalations;  
	        }  
	    });
  
}

@Override
public List<Integer> getEscalationIds() {
	String sql ="select id from ssaescalation;";
	System.out.println(sql);
	
	return template.query("select id from ssaescalation;",new ResultSetExtractor<List<Integer>>(){  
	    
	     public List<Integer> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	        List<Integer> list=new ArrayList<Integer>();  
	        while(rs.next()){  
              list.add(rs.getInt(1));
	        }  
	        return list;  
	        }  
	    });
}

@Override
public List<Escalations> getAllEscalations() {
	return template.query("select * from ssaescalation;",new ResultSetExtractor<List<Escalations>>(){  
	    
	     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	        List<Escalations> list=new ArrayList<Escalations>();  
	        while(rs.next()){  
	        Escalations e=new Escalations();  
	        e.setSiteid(rs.getString(1));
	        e.setSitename(rs.getString(2));
	        e.setTechnology(rs.getString(3));
	        e.setSite_status(rs.getString(4));
	        e.setRo_region(rs.getString(5));
	        e.setProject_scope(rs.getString(6));
	        e.setStartdate(rs.getString(7));
	        e.setEnddate(rs.getString(8));
	        e.setStatus(rs.getString(9));
	        e.setOriginator_mail(rs.getString(10));
	        e.setResponsible(rs.getString(11));
	        e.setCategory(rs.getString(12));
	        e.setProblem_description(rs.getString(13));
	        e.setRequested_action_history(rs.getString(14));
	        e.setMail_reference(rs.getString(15));
	        
	        if(rs.getString(8)==null) {
	        	System.out.println("......No of Days >>>>>>>>+NULL");
	        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
	        }
	        else
	        {
	        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
	        }
	        
	        
	        
	        e.setId(rs.getInt(18));
	        
	        
	        
	        
	        
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    });
}

@Override
public List<Escalations> getEscalationsById(int userid) {
	String sql ="select * from ssaescalation where userid="+userid+" ;";
	System.out.println(sql);
	
	return template.query("select * from ssaescalation where userid="+userid+";",new ResultSetExtractor<List<Escalations>>(){  
	    
	     public List<Escalations> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	        List<Escalations> list=new ArrayList<Escalations>();  
	        while(rs.next()){  
	        Escalations e=new Escalations();  
	        e.setSiteid(rs.getString(1));
	        e.setSitename(rs.getString(2));
	        e.setTechnology(rs.getString(3));
	        e.setSite_status(rs.getString(4));
	        e.setRo_region(rs.getString(5));
	        e.setProject_scope(rs.getString(6));
	        e.setStartdate(rs.getString(7));
	        e.setEnddate(rs.getString(8));
	        e.setStatus(rs.getString(9));
	        e.setOriginator_mail(rs.getString(10));
	        e.setResponsible(rs.getString(11));
	        e.setCategory(rs.getString(12));
	        e.setProblem_description(rs.getString(13));
	        e.setRequested_action_history(rs.getString(14));
	        e.setMail_reference(rs.getString(15));
	        
	        if(rs.getString(8)==null) {
	        	System.out.println("......No of Days >>>>>>>>+NULL");
	        e.setLead_time_in_days(getDateDifferences(rs.getString(7)));
	        }
	        else
	        {
	        e.setLead_time_in_days(getDateDifferences(rs.getString(7), rs.getString(8) ));
	        }
	        e.setId(rs.getInt(18));
	       
	        
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    });
}


	
}
