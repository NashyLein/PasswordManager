package com.nashy.password.manager.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appCred")
public class ApplicationCredentials {
	
	@Id
	private String locationName;
	
	@Column(name="login")
	private String login;
	
	@Column(name="password")
	private String password;

	public ApplicationCredentials() {
		super();
	}

	public ApplicationCredentials(String locationName, String login, String password) {
		super();
		this.locationName = locationName;
		this.login = login;
		this.password = password;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
