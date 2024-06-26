package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "textbook_id")
	private Integer textbookId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "item_status")
	private Integer itemStatus;

	public Request() {

	}

	public Request(Integer userId, Integer itemId, Integer itemStatus) {
		this.userId = userId;
		this.textbookId = itemId;
		this.itemStatus = itemStatus;
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

	public Integer getItemStatus() {
		return itemStatus;
	}

}