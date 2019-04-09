package com.rf.rftool.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User implements Serializable {
	
	@Id 
	private int userid;
	
	@NotNull
	@NotEmpty 
	private String username;
	
	@NotNull
	@NotEmpty
	private String userroll;
	
	
	@NotNull
	@Email
	@NotEmpty
	private String mailid;
	
	@NotNull
	@Size(min = 6, max = 15)
	@NotEmpty
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
