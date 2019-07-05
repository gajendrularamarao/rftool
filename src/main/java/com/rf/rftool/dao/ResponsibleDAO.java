package com.rf.rftool.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
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
	
	public void getinsertexclesheet() throws IOException, ParseException
	{
		
		
		FileInputStream input = new FileInputStream("C:/Users/varapras/Downloads/ssaescalation.xls");
        POIFSFileSystem fs = new POIFSFileSystem( input );
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        Row row;
        for(int i=1; i<=sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);
            
            try {
            String siteid = row.getCell(0).getStringCellValue();
            String sitename = row.getCell(1).getStringCellValue();
            String technology = row.getCell(2).getStringCellValue();
            String site_status = row.getCell(3).getStringCellValue();
            String ro_region = row.getCell(4).getStringCellValue();
            String project_scope = row.getCell(5).getStringCellValue();
            String startdate = row.getCell(6).getStringCellValue();
            String enddate = row.getCell(7).getStringCellValue();
            
            String status = row.getCell(8).getStringCellValue();
            String originator_mail = row.getCell(9).getStringCellValue();
            String responsible = row.getCell(10).getStringCellValue();
            String category =row.getCell(11).getStringCellValue();                                 
            String problem_description = row.getCell(12).getStringCellValue();
            String requested_action_history = row.getCell(13).getStringCellValue();
           
            String mail_reference = row.getCell(14).getStringCellValue();
            
            int lead_time_in_days = (int) row.getCell(15).getNumericCellValue();
            int userid = (int) row.getCell(16).getNumericCellValue();
            
            
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
    				"userid) values('"+siteid+"','"+sitename+"','"+technology+
    				"','"+site_status+"','"+ro_region+"','"+project_scope+
    				"','"+startdate+"','"+enddate+"','"+status+
    				"','"+originator_mail +"','"+responsible +"','"+ category +"', '"+ problem_description +"','"+requested_action_history+"','" +mail_reference+
    				"',"+lead_time_in_days+","+userid+")";
    		System.out.println(sql);
    	     template.update(sql);  
            
            
            
            System.out.println(" "+siteid + " : "+sitename +":"+  technology +":"+problem_description+":"  );
            System.out.println("row number >>>>>"+i);
            }
            catch(NullPointerException e) 
            { 
                System.out.print("NullPointerException Caught"); 
            }  
        }
        
        System.out.println("Success import excel to mysql table");
    }
		
	
	
	
	
	
}	


