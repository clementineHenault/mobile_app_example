package com.model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class Representative {
	private String username;
	private String password;
	private boolean isAdmin;
	
	public Representative() {
		
	}
	
	public Representative(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Representative(String username, String password, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Representative [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
}
