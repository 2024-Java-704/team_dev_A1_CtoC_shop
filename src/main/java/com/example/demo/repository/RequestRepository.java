package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {

	List<Request> findByTextbookId(Integer textbookId); //該当の教科書IDの募集リストを取得

}
