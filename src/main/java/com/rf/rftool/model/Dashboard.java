package com.rf.rftool.model;

import java.io.Serializable;

public class Dashboard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String responsible;
	private String project_scope;
	private int closed;
	private int wip;
	private int scheduled;
	private int open; 
	private String status;
	private int statuscount;
	
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
	
	

}
