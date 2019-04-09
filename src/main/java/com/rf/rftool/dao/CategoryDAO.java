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
import com.rf.rftool.model.Status;

@Service
public class CategoryDAO implements ICategory{

    JdbcTemplate template;  
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	
	@Override
	public Category save(Category p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategoryList() {
		return template.query("SELECT * FROM category;",new ResultSetExtractor<List<Category>>(){  
		    
		     public List<Category> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Category> categoryList=new ArrayList<Category>();  
		        while(rs.next()){  
		        Category e=new Category();  
		        e.setCategoryid(rs.getInt(1));
		        e.setCategoryname(rs.getString(2));
		        categoryList.add(e);  
		        }  
		        return categoryList;  
		        }  
		    });
		
	}

	@Override
	public void update(Category p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getUser(Category p) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
