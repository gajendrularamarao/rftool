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

import com.rf.rftool.model.Projectscope;


@Service
public class ProjectscopeDAO implements IProjectscope {

	
    JdbcTemplate template;  
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	@Override
	public Projectscope save(Projectscope p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Projectscope> getProjectscopeList() {
		return template.query("SELECT * FROM projectscope",new ResultSetExtractor<List<Projectscope>>(){  
		    
		     public List<Projectscope> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Projectscope> projectscopeList=new ArrayList<Projectscope>();  
		        while(rs.next()){  
		        Projectscope e=new Projectscope();  
		        e.setProjectscopeid(rs.getInt(1));
		        e.setProjectscopename(rs.getString(2));
		        projectscopeList.add(e);  
		        }  
		        return projectscopeList;  
		        }  
		    });
		}
		
	

	@Override
	public void update(Projectscope p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Projectscope getProjectscope(Projectscope p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
