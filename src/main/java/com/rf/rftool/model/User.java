package com.rf.rftool.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class User implements Serializable {
	
	@Id @NotNull
	private int userid;
	
	@NotNull
	private String username;
	
	@NotNull
	private String userroll;
	
	@NotNull
	private String mailid;
	
	@NotNull
	private String userpass;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserroll() {
		return userroll;
	}

	public void setUserroll(String userroll) {
		this.userroll = userroll;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}


}
