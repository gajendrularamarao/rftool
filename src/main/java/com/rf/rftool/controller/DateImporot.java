package com.rf.rftool.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import jxl.write.WriteException;


public class DateImporot {
	
	public static void main(String[] args)throws IOException, WriteException, SQLException {
	
		JdbcTemplate template;  
		DataSource dataSource = null;
		template = new JdbcTemplate(dataSource);
		
		
		 FileInputStream input = new FileInputStream("/Users/nisum/Documents/ssaescalation.xls");
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
             String startdate = row.getCell(6).getDateCellValue().toString();
             String enddate = row.getCell(7).getDateCellValue().toString();
             String status = row.getCell(8).getStringCellValue();
             String originator_mail = row.getCell(9).getStringCellValue();
             String responsible = row.getCell(10).getStringCellValue();
             
             String category; 
             if(row.getCell(11).getStringCellValue()!=null)
             {     category =      row.getCell(11).getStringCellValue();                                 }
             else
             {category = ""; }
             String problem_description;
             if(row.getCell(12).getStringCellValue()!=null)
             {
                 problem_description = row.getCell(12).getStringCellValue();
             }else {
            	  problem_description="";}
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
     				"','"+responsible+"','"+category+"','"+ problem_description+"',"+  originator_mail+"','"+requested_action_history+"','" +mail_reference+
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

