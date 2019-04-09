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
import com.rf.rftool.model.Responsible;

@Service
public class ResponsibleDAO implements IResponsible{
 
	 JdbcTemplate template;  
		
		@Autowired
		public void setDataSource(DataSource dataSource) {
			template = new JdbcTemplate(dataSource);
		}
	@Override
	public Responsible save(Responsible p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Responsible> getResponsibleList() {
		return template.query("SELECT * FROM responsible",new ResultSetExtractor<List<Responsible>>(){  
		    
		     public List<Responsible> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Responsible> responsibleList=new ArrayList<Responsible>();  
		        while(rs.next()){  
		        Responsible e=new Responsible();  
		        e.setResponsibleid(rs.getInt(1));
		        e.setResponsiblename(rs.getString(2));
		        responsibleList.add(e);  
		        }  
		        return responsibleList;  
		        }  
		    });
	}

	@Override
	public void update(Responsible p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Responsible getResponsible(Responsible p) {
		// TODO Auto-generated method stub
		return null;
	}

}
