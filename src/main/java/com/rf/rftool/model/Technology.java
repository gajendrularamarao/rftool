package com.rf.rftool.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Technology implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @NotNull
	private int technologyid;
	
	public int getTechnologyid() {
		return technologyid;
	}

	public void setTechnologyid(int technologyid) {
		this.technologyid = technologyid;
	}

	public String getTechnologyname() {
		return technologyname;
	}

	public void setTechnologyname(String technologyname) {
		this.technologyname = technologyname;
	}

	@NotNull
	private String technologyname;

}
