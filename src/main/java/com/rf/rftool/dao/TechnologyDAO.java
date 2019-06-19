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

import com.rf.rftool.model.Responsible;
import com.rf.rftool.model.Technology;

@Service
public class TechnologyDAO implements ITechnology {

	 JdbcTemplate template;  
		
		@Autowired
		public void setDataSource(DataSource dataSource) {
			template = new JdbcTemplate(dataSource);
		}
	
	@Override
	public Technology save(Technology t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Technology> getTechnologyList() {
		
		return template.query("SELECT * FROM technology",new ResultSetExtractor<List<Technology>>(){  
		    
		     public List<Technology> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Technology> technologyList=new ArrayList<Technology>();  
		        while(rs.next()){  
		        Technology e=new Technology();  
		        e.setTechnologyid(rs.getInt(1));
		        e.setTechnologyname(rs.getString(2));
		        technologyList.add(e);  
		        }  
		        return technologyList;  
		        }  
		    });
		
	}

	@Override
	public void update(Technology t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Technology getTechnology(Technology t) {
		// TODO Auto-generated method stub
		return null;
	}

}
