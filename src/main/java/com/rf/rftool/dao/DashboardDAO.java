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
			return template.query("select userid ,responsible , project_scope , status , count(status) from ssaescalation  \n" + 
					" group  by status ,project_scope , responsible , userid having userid="+ user.getUserid()+ ";",new ResultSetExtractor<List<Dashboard>>(){  
			    
			     public List<Dashboard> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Dashboard> responsibleList=new ArrayList<Dashboard>();  
			        while(rs.next()){  
			        	Dashboard e=new Dashboard();  
			        	e.setResponsible(rs.getString(2));
			        	e.setProject_scope(rs.getString(3));
			        	e.setStatus(rs.getString(4));
			        	e.setStatuscount(rs.getInt(5));
			        	responsibleList.add(e);
			       
			        }  
			        return responsibleList;  
			        }  
			    });
			
		}
	
	
}
