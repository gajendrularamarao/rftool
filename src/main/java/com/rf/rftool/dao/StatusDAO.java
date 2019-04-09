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

import com.rf.rftool.model.Status;

@Service
public class StatusDAO implements IStatus{
	
    JdbcTemplate template;  
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	

	@Override
	public Status save(Status p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status> getStatusList() {
		return template.query("SELECT * FROM status",new ResultSetExtractor<List<Status>>(){  
		    
		     public List<Status> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Status> statuslist=new ArrayList<Status>();  
		        while(rs.next()){  
		        Status e=new Status();  
		        e.setStatusid(rs.getInt(1));
		        e.setStatusname(rs.getString(2));
		        statuslist.add(e);  
		        }  
		        return statuslist;  
		        }  
		    });
		}
	@Override
	public void update(Status p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getUser(Status p) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
