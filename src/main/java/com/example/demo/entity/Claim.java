package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "claims")
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String message;
	@Column(name = "claim_status")
	private Integer claimStatus;
	
	public Claim() {
	}
	
	public Claim(String message) {
		this.message = message;
		this.claimStatus = 1;
	}
	
	public Claim(Integer id, String message, Integer claimStatus) {
		this.id = id;
		this.message = message;
		this.claimStatus = claimStatus;
	}

	public Integer getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Integer getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(Integer claimStatus) {
		this.claimStatus = claimStatus;
	}
}
