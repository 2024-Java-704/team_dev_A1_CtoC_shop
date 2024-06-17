package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.History;

public interface HistoryRepository extends JpaRepository<History, Integer>{

	History findByTextbookIdAndUserId(Integer textbookId, Integer userId);

	History findOneByTextbookIdAndUserId(Integer textbookId, Integer userId);

	History findOneById(Integer historyId);

}
