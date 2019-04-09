package com.rf.rftool.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Responsible implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	public int getResponsibleid() {
		return responsibleid;
	}

	public void setResponsibleid(int responsibleid) {
		this.responsibleid = responsibleid;
	}

	public String getResponsiblename() {
		return responsiblename;
	}

	public void setResponsiblename(String responsiblename) {
		this.responsiblename = responsiblename;
	}

	@Id @NotNull
	private int responsibleid;
	
	@NotNull
	private String responsiblename;

}
