package com.rf.rftool.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rf.rftool.model.Escalations;
import com.rf.rftool.model.User;
import com.rf.rftool.service.IEscalationservice;
import com.rf.rftool.dao.EscalationsDAO;

@Service
public class EscalationService implements IEscalationservice {
	
	@Autowired
	EscalationsDAO escalationsDAO;

	@Override
	public Escalations save(Escalations e , User user) {
		return escalationsDAO.save(e , user);
	}

	@Override
	public List<Escalations> getAllEscalations(User user1) {
		// TODO Auto-generated method stub
		return escalationsDAO.getAllEscalations(user1);
	}

	@Override
	public List<Escalations> getEscalationById(User user, int id) {
		
		return escalationsDAO.getEscalationsById(user, id);
		
	}

	@Override
	public List<Integer> getEscalationIds(User user) {
		return escalationsDAO.getEscalationIds(user);
	}

	@Override
	public List<Escalations> getEscalationBySerach(User user, String siteid, String sitename, String startdate,
			String enddate, String status) {
		
		return escalationsDAO.getEscalationBySerach(user, siteid, sitename, startdate, enddate, status);
	}

	@Override
	public Escalations update(Escalations e, User user) {
		
		
		
		return escalationsDAO.update(e, user);
	}

	@Override
	public List<Integer> getEscalationIds() {
		
		return escalationsDAO.getEscalationIds();
	}

	@Override
	public List<Escalations> getAllEscalations() {
		// TODO Auto-generated method stub
		return escalationsDAO.getAllEscalations();
	}

	@Override
	public List<Escalations> getEscalationById(int userid) {
		// TODO Auto-generated method stub
		return escalationsDAO.getEscalationsById(userid);
	}

	@Override
	public List<Escalations> getEscalationBySerach(String siteid, String sitename, String startdate, String enddate,
			String status) {
		
		return escalationsDAO.getEscalationBySerach(siteid, sitename, startdate, enddate, status);
	}
	

	public boolean createExcle(List<Escalations> escalations ,ServletContext context, HttpServletRequest request ,  HttpServletResponse  response ) {
		
		String      filepath =   request.getSession().getServletContext().getRealPath("/WEB-INF/excel/"+"escalations"+".xls");          
		File file = new File(filepath);
		
		try {
			System.out.println("enete for creating file >>>>>");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("escalations");
		sheet.setDefaultColumnWidth(30);
		
		HSSFRow  headerrow = sheet.createRow(0);
		
		HSSFCell  SiteName = headerrow.createCell(0);
		SiteName.setCellValue("siteid");
		HSSFCell  siteid = headerrow.createCell(1);
		siteid.setCellValue("Site Name");
		
		HSSFCell  Technology1  = headerrow.createCell(2);
		Technology1 .setCellValue("Technology Name ");
		HSSFCell  SiteStatus = headerrow.createCell(3);
		SiteStatus.setCellValue("Site Status");
		
		HSSFCell  RORegion = headerrow.createCell(4);
		RORegion.setCellValue("RO Region");
		HSSFCell  ProjectScope = headerrow.createCell(5);
		ProjectScope.setCellValue("Project Scope");
		
		HSSFCell  StartDate = headerrow.createCell(6);
		StartDate.setCellValue("Start Date");
		HSSFCell  EndDate = headerrow.createCell(7);
		EndDate.setCellValue("End Date");
		
		HSSFCell  Status = headerrow.createCell(8);
		Status.setCellValue("Status");
		HSSFCell  OriginatorMail	 = headerrow.createCell(9);
		OriginatorMail.setCellValue("Originator Mail");
		
		HSSFCell  Responsible = headerrow.createCell(10);
		Responsible.setCellValue("Responsible");
		HSSFCell  Category = headerrow.createCell(11);
		Category.setCellValue("Category");
		
		HSSFCell  ProblemDescription	 = headerrow.createCell(12);
		ProblemDescription	.setCellValue("Problem Description");
		HSSFCell  RequestActionhistory = headerrow.createCell(13);
		RequestActionhistory.setCellValue("Request Action history");
		
		HSSFCell  MailRefereance = headerrow.createCell(14);
		MailRefereance.setCellValue("Mail Refereance");
		HSSFCell  LeadTime = headerrow.createCell(15);
		LeadTime.setCellValue("Lead Time");
		
		
		
		
		int i=1;
		
		for(Escalations escalation : escalations) {
			
			HSSFRow  datarow = sheet.createRow(i);
			
			HSSFCell  siteId = datarow.createCell(0);
			siteId.setCellValue(escalation.getSiteid());
		
			HSSFCell  sitename = datarow.createCell(1);
			sitename.setCellValue(escalation.getSitename());
			
			HSSFCell  Technology = datarow.createCell(2);
			Technology.setCellValue(escalation.getTechnology());
			
			HSSFCell  Site_status = datarow.createCell(3);
			Site_status.setCellValue(escalation.getSite_status());
			
			HSSFCell  getRo_region = datarow.createCell(4);
			getRo_region.setCellValue(escalation.getRo_region());
		
			HSSFCell  getProject_scope = datarow.createCell(5);
			getProject_scope.setCellValue(escalation.getProject_scope());
			
			HSSFCell  getStartdate = datarow.createCell(6);
			getStartdate.setCellValue(escalation.getStartdate());
		
			HSSFCell  getEnddate = datarow.createCell(7);
			getEnddate.setCellValue(escalation.getEnddate());
			
			HSSFCell  getStatus = datarow.createCell(8);
			getStatus.setCellValue(escalation.getStatus());
		
			HSSFCell  getOriginator_mail = datarow.createCell(9);
			getOriginator_mail.setCellValue(escalation.getOriginator_mail());
			
			HSSFCell  getResponsible = datarow.createCell(10);
			getResponsible.setCellValue(escalation.getResponsible());
		
			HSSFCell  getCategory = datarow.createCell(11);
			getCategory.setCellValue(escalation.getCategory());
			
			HSSFCell  getProblem_description = datarow.createCell(12);
			getProblem_description.setCellValue(escalation.getProblem_description());
		
			HSSFCell  getRequested_action_history = datarow.createCell(13);
			getRequested_action_history.setCellValue(escalation.getRequested_action_history());
			
			HSSFCell  getMail_reference = datarow.createCell(14);
			getMail_reference.setCellValue(escalation.getMail_reference());
		
			HSSFCell  getLead_time_in_days = datarow.createCell(15);
			getLead_time_in_days.setCellValue(escalation.getLead_time_in_days());
			
			
			
			
			
			i++;
		}
		System.out.println("enter  creating file >>>>>");
		workbook.write(fileOutputStream);	
		fileOutputStream.flush();
		fileOutputStream.close();
		return true;
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		
	}
	
   public void filedownload(String fullpath ,ServletContext context, HttpServletResponse response , String filename  ) {
	   File file = new File(fullpath);
	   final int BUFFER_SIZE = 4096;
	   
	   if(file.exists())
	   {
		   try {
			 FileInputStream  inputStream = new FileInputStream(file);
			 String mimetype = context.getMimeType(fullpath);
			 response.setContentType(mimetype);
			 response.setHeader("content-disposition","attachment; filename="+filename);
			 OutputStream outputStream = response.getOutputStream();
			 byte[] buffer = new byte[BUFFER_SIZE];
			 int bytesRead = -1;
			 while((bytesRead = inputStream.read(buffer))!= -1) {
				 outputStream.write( buffer, 0 , bytesRead);
				 
			 }
			 inputStream.close(); 
			 outputStream.close();
			 file.delete();
			   
		   }catch(Exception e) {
			   
		   }
		   
		   
		   
	   }
	   
	   
	   
   }

@Override
public List<Escalations> getEscalationsByuserId(int userid) {
	// TODO Auto-generated method stub
	return escalationsDAO.getEscalationsByuserId(userid);
}
	
	
}
