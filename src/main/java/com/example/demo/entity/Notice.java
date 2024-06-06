package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notice")
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer userId;
	private String message;
	private Integer noticeStatus;
	
	public Notice() {
	}
	
	public Notice(Integer userId, String message) {
		this.userId = userId;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getMessage() {
		return message;
	}

	public Integer getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
}
