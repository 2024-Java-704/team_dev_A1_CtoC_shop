package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

//Modelです
@Component
@SessionScope
public class Account {
	private Integer id;
	private Integer userStatus;

	public Account() {	
	}
	
	public Account(Integer id, Integer userStatus) {
		this.id = id;
		this.userStatus = userStatus;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getId() {
		return id;
	}

	public Integer getUserStatus() {
		return userStatus;
	}
}