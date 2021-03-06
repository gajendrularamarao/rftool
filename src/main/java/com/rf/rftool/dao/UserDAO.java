package com.rf.rftool.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;

@Service
public class UserDAO implements IUser {
	
    JdbcTemplate template;  
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	

	@Override
	public User save(User p) throws SQLException   {
		 System.out.print("enter User Registration Save");
		String sql="INSERT INTO user_details (userid, user_name, user_roll, user_mailid, user_pass)"
				+ " VALUES (0, ' "+p.getUsername()+"','"+p.getUserroll()+ "', '"+ p.getMailid()+ "', '"+p.getUserpass() +" ');";
		System.out.println(sql);
	     
		 int check = template.update(sql);
	     
	     System.out.print("enter user logn Query" + check);
	     
			return template.query("SELECT * FROM user_details WHERE userid=(SELECT MAX(userid) FROM user_details);" ,new ResultSetExtractor<User>(){  
			    
			     public User extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			     User user= new User();
			        while(rs.next()){  
			       
			        user.setUserid(rs.getInt(1));
			        user.setUsername(rs.getString(2));
			        user.setUserroll(rs.getString(3));
			        user.setMailid(rs.getString(4));
			        user.setUserpass(rs.getString(5));
			        }  
			        return user;  
			        }  
			    });
	     
	}

	@Override
	public List<User> getAllUsers() {
		
		return template.query("select * from user_details",new ResultSetExtractor<List<User>>(){  
		    
		     public List<User> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User e=new User();  
		        e.setUserid(rs.getInt(1));
		        e.setUsername(rs.getString(2));
		        e.setUserroll(rs.getString(3));
		        e.setMailid(rs.getString(4));
		        e.setUserpass(rs.getString(5));
		        
		          list.add(e);  
		        }  
		        return list;  
		        }  
		    });
		
	
	}

	@Override
	public User update(User p) {
		
		String sql ="UPDATE user_details SET user_name ='"+p.getUsername()+"', user_roll ='"+ p.getUserroll()  + "', user_mailid ='"+ p.getMailid()+"',"
				+ "user_pass ='"+ p.getUserpass()+"'  WHERE userid = "+p.getUserid()+";" ; 
		System.out.println("Update the record >>>>>>"+ sql  );
		template.update(sql);		
		 return template.query("SELECT * FROM user_details WHERE userid = "+p.getUserid()+";" ,new ResultSetExtractor<User>(){  
			    
		     public User extractData(ResultSet rs) throws SQLException,  
		         DataAccessException {  
		      	 User user= new User();
		         while(rs.next()){  
		         user.setUserid(rs.getInt(1));
		         user.setUsername(rs.getString(2));
		         user.setUserroll(rs.getString(3));
		         user.setMailid(rs.getString(4));
		         }  
		        return user;  
		        }  
		    });
		
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(User p) {
		
		System.out.print("enter user logn Query");
		return template.query("select * from user_details where user_mailid = '"+p.getMailid()+"' and user_pass = '"+p.getUserpass()+"'" ,new ResultSetExtractor<User>(){  
		    
		     public User extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		     User user= new User();
		        while(rs.next()){  
		       
		        user.setUserid(rs.getInt(1));
		        user.setUsername(rs.getString(2));
		        user.setUserroll(rs.getString(3));
		        user.setMailid(rs.getString(4));
		        user.setUserpass(rs.getString(5));
		        }  
		        if((user.getMailid()==null)||(user.getUserpass()==null)) {
		        return user=null;  
		        }
		        else { return user;  }
		        
		        }  
		    });
		
		
		
		
	}



	@Override
	public Boolean userExitingChecking(User p) {
		
		Boolean isAvailableUser=false;
		
		List<User> user  = template.query("select * from user_details",new ResultSetExtractor<List<User>>(){  
		    
		     public List<User> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<User> list=new ArrayList<User>();  
		        while(rs.next()){  
		        User e=new User();  
		        e.setUserid(rs.getInt(1));
		        e.setUsername(rs.getString(2));
		        e.setUserroll(rs.getString(3));
		        e.setMailid(rs.getString(4));
		        e.setUserpass(rs.getString(5));
		        
		          list.add(e);  
		        }  
		        return list;  
		        }  
		    });
		
		for( int i=0; i<user.size(); i++)
		{
		  if(user.get(i).getMailid().equalsIgnoreCase(p.getMailid())) {
			  isAvailableUser=true;
		  }
			
		}
		
		
		return isAvailableUser;
	
	}

	
	
}
