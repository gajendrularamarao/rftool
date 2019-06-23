package com.rf.rftool.model;

import java.io.Serializable;

public class Dashboard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String responsible;
	private String project_scope;
	private String originator_mail;
	public String getOriginator_mail() {
		return originator_mail;
	}
	public void setOriginator_mail(String originator_mail) {
		this.originator_mail = originator_mail;
	}
	private int closed;
	private int wip;
	private int scheduled;
	private int open; 
	private int reopen;
	public int getReopen() {
		return reopen;
	}
	public void setReopen(int reopen) {
		this.reopen = reopen;
	}
	private String status;
	private int statuscount;
	private String username;
	
	private String mailid;
	private int userid;
	private int total;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatuscount() {
		return statuscount;
	}
	public void setStatuscount(int statuscount) {
		this.statuscount = statuscount;
	}
	
	
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getProject_scope() {
		return project_scope;
	}
	public void setProject_scope(String project_scope) {
		this.project_scope = project_scope;
	}
	public int getClosed() {
		return closed;
	}
	public void setClosed(int closed) {
		this.closed = closed;
	}
	public int getWip() {
		return wip;
	}
	public void setWip(int wip) {
		this.wip = wip;
	}
	public int getScheduled() {
		return scheduled;
	}
	public void setScheduled(int scheduled) {
		this.scheduled = scheduled;
	}
	public int getOpen() {
		return open;
	}
	public void setOpen(int open) {
		this.open = open;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
