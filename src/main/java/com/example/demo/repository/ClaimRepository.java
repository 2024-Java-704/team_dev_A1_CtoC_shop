package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

	List<Claim> findByOrderById();	//問い合わせメッセージをID順に取得

	List<Claim> findByOrderByIdDesc();	//問い合わせメッセージをIDの逆順に取得

	List<Claim> findByClaimStatus(Integer claimStatus);	//特定の状態の問い合わせメッセージをすべて取得

}
