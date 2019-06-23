package com.rf.rftool.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.rf.rftool.model.Category;
import com.rf.rftool.model.Dashboard;
import com.rf.rftool.model.Responsible;
import com.rf.rftool.model.User;

@Service
public class DashboardDAO implements IDashboard {

	 JdbcTemplate template;  
		
		@Autowired
		public void setDataSource(DataSource dataSource) {
			template = new JdbcTemplate(dataSource);
		}
	
			@Override
		public List<Dashboard> getDashboard(User user) {
			return template.query("select userid ,originator_mail ,responsible , project_scope , status , count(status) from ssaescalation  \n" + 
					" group  by status ,project_scope , responsible , userid ,originator_mail having userid="+ user.getUserid()+ ";",new ResultSetExtractor<List<Dashboard>>(){  
			    
			     public List<Dashboard> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Dashboard> responsibleList=new ArrayList<Dashboard>();  
			        while(rs.next()){  
			        	Dashboard e=new Dashboard();  
			        	e.setMailid(rs.getString(2));
			        	e.setResponsible(rs.getString(3));
			        	e.setProject_scope(rs.getString(4));
			        	e.setStatus(rs.getString(5));
			        	e.setStatuscount(rs.getInt(6));
			        	responsibleList.add(e);
			       
			        }  
			        return responsibleList;  
			        }  
			    });
			
		}

			@Override
			public List<Dashboard> getAdminDashboard() {
				
				return template.query("select status, count(status) from ssaescalation  group by status;",new ResultSetExtractor<List<Dashboard>>(){  
				    
				     public List<Dashboard> extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				        List<Dashboard> mainadmindashboard=new ArrayList<Dashboard>();  
				        Dashboard e=new Dashboard();
				        while(rs.next()){  
				        	  
				        	if(rs.getString(1).equalsIgnoreCase("Closed"))
				        		e.setClosed(rs.getInt(2));
				        	if(rs.getString(1).equalsIgnoreCase("Open"))
				        		e.setOpen(rs.getInt(2));
				        	if(rs.getString(1).equalsIgnoreCase("WIP"))
				        		e.setWip(rs.getInt(2));
				        	if(rs.getString(1).equalsIgnoreCase("Scheduled"))
				        		e.setScheduled(rs.getInt(2));
				        	if(rs.getString(1).equalsIgnoreCase("Reopen"))
				        		e.setReopen(rs.getInt(2));
				        }
				        e.setTotal(e.getClosed()+e.getOpen()+e.getWip()+e.getScheduled()+e.getReopen());
				        mainadmindashboard.add(e);
				        return mainadmindashboard;  
				        }  
				    });
			}

			@Override
			public List<Dashboard> getDashboardAll() {
				return template.query("select userid ,originator_mail ,responsible , project_scope , status , count(status) from ssaescalation  \n" + 
						" group  by status ,project_scope , responsible , userid ,originator_mail",new ResultSetExtractor<List<Dashboard>>(){  
				    
				     public List<Dashboard> extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				        List<Dashboard> responsibleList=new ArrayList<Dashboard>();  
				        while(rs.next()){  
				        	Dashboard e=new Dashboard();  
				        	e.setMailid(rs.getString(2));
				        	e.setResponsible(rs.getString(3));
				        	e.setProject_scope(rs.getString(4));
				        	e.setStatus(rs.getString(5));
				        	e.setStatuscount(rs.getInt(6));
				        	responsibleList.add(e);
				       
				        }  
				        return responsibleList;  
				        }  
				    });
			}
	
	
}
