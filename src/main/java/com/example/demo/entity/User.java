package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "personal_number")
	private String personalNumber;

	private String password;

	@Column(name = "user_status")
	private Integer userStatus;

	private String introduce;

	public User() {

	}

	public User(String personalNumber, String password, Integer userStatus, String introduce) {
		this.personalNumber = personalNumber;
		this.password = password;
		this.userStatus = userStatus;
		this.introduce = introduce;
	}

	public Integer getId() {
		return id;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}
