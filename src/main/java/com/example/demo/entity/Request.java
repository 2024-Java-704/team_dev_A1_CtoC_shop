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
	@Column(name = "item_id")
	private Integer itemId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "item_status")
	private Integer itemStatus;

	public Request() {

	}

	public Request(Integer userId, Integer itemId) {
		this.userId = userId;
		this.itemId = itemId;

	}

	public Integer getId() {
		return id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getItemStatus() {
		return itemStatus;
	}

}