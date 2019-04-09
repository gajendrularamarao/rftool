package com.rf.rftool.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Status implements Serializable{


	private static final long serialVersionUID = 1L;

	public int getStatusid() {
		return statusid;
	}
	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	@Id @NotNull
	private int statusid;
	
	@NotNull
	private String statusname;
	
}

