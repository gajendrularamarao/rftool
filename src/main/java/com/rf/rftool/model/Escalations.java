package com.rf.rftool.model;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

public class Escalations {
	
	@Id 
	private int id;
	
	@NotNull
	@NotEmpty
	private String siteid;
	@NotNull
	@NotEmpty
	private String sitename;
	@NotNull
	@NotEmpty
	private String technology;
	@NotNull
	@NotEmpty
	private String site_status;
	@NotNull
	@NotEmpty
	private String ro_region;
	@NotNull
	@NotEmpty
	private String project_scope;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotEmpty
	private String startdate;
	
	private String enddate;
	@NotNull
	@NotEmpty
	private String status;
	@NotNull
	@NotEmpty
	private String originator_mail;
	@NotNull
	@NotEmpty
	private String responsible;
	@NotNull
	@NotEmpty
	private String category;
	@NotNull
	@NotEmpty
	private String problem_description;
	@NotNull
	@NotEmpty
	private String requested_action_history;
	
	@Email
	private String mail_reference;
	
	@NotNull
	private int lead_time_in_days;
	@NotNull
	private int userid;
	
	
     public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getSite_status() {
		return site_status;
	}
	public void setSite_status(String site_status) {
		this.site_status = site_status;
	}
	public String getRo_region() {
		return ro_region;
	}
	public void setRo_region(String ro_region) {
		this.ro_region = ro_region;
	}
	public String getProject_scope() {
		return project_scope;
	}
	public void setProject_scope(String project_scope) {
		this.project_scope = project_scope;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOriginator_mail() {
		return originator_mail;
	}
	public void setOriginator_mail(String originator_mail) {
		this.originator_mail = originator_mail;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProblem_description() {
		return problem_description;
	}
	public void setProblem_description(String problem_description) {
		this.problem_description = problem_description;
	}
	public String getRequested_action_history() {
		return requested_action_history;
	}
	public void setRequested_action_history(String requested_action_history) {
		this.requested_action_history = requested_action_history;
	}
	public String getMail_reference() {
		return mail_reference;
	}
	public void setMail_reference(String mail_reference) {
		this.mail_reference = mail_reference;
	}
	public int getLead_time_in_days() {
		return lead_time_in_days;
	}
	public void setLead_time_in_days(int lead_time_in_days) {
		this.lead_time_in_days = lead_time_in_days;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	

}
