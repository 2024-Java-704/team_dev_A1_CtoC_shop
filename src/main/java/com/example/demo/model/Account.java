package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.NoticeRepository;

//Modelです
@Component
@SessionScope
public class Account {

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	ClaimRepository claimRepository;

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

	public Integer getNoticeCount() {
		return noticeRepository.findByUserIdAndNoticeStatus(id, 1).size();
	}

	public Integer getClaimCount() {
		return claimRepository.findByClaimStatus(1).size();
	}
}