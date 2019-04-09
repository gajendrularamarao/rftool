package com.rf.rftool.dao;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	public void save(Escalations e , User user){
			
		String sql="insert into ssaescalation(siteid,\n" + 
				"sitename,\n" + 
				"technology,\n" + 
				"site_status,\n" + 
				"ro_region,\n" + 
				"project_scope,\n" + 
				"startdate,\n" + 
				"enddate,\n" + 
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
				"','"+e.getStartdate()+"','"+e.getEnddate()+"','"+e.getStatus()+"','"+e.getOriginator_mail()+
				"','"+e.getResponsible()+"','"+e.getCategory()+"','"+e.getProblem_description()+"','"+e.getRequested_action_history()+"','" +e.getMail_reference()+
				"',"+e.getLead_time_in_days()+","+user.getUserid()+")";
		System.out.println(sql);
	     template.update(sql);  
		
	}

	@Override
	public List<Escalations> getAllEscalations() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
