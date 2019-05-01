package com.rf.rftool.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<Escalations> getAllEscalations() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
