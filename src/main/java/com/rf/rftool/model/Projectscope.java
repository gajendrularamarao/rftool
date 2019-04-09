package com.rf.rftool.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Projectscope implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @NotNull
	private int projectscopeid;
	
	public int getProjectscopeid() {
		return projectscopeid;
	}

	public void setProjectscopeid(int projectscopeid) {
		this.projectscopeid = projectscopeid;
	}

	public String getProjectscopename() {
		return projectscopename;
	}

	public void setProjectscopename(String projectscopename) {
		this.projectscopename = projectscopename;
	}

	@NotNull
	private String projectscopename;

}
