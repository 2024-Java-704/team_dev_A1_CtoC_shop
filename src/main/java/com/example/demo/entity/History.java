package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //購入履歴ID
	
	@Column(name = "textbook_id")
	private Integer textbookId;
	
	@Column(name = "user_id")
	private Integer userId;
	
	private Integer status;

	public History() {
	}
	
	public History(Integer textbookId,Integer userId,Integer status) {
		this.textbookId=textbookId;
		this.userId=userId;
		this.status=status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public Integer getTextbookId() {
		return textbookId;
	}

	public Integer getUserId() {
		return userId;
	}
}
