package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Textbook;

public interface TextbookRepository extends JpaRepository<Textbook, Integer>{

	List<Textbook> findByTitleLike(String keyword);

	Textbook findOneById(Integer textbookId);

}
