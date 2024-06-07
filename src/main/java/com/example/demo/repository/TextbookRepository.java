package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Textbook;

public interface TextbookRepository extends JpaRepository<Textbook, Integer>{


	List<Textbook> findByNameLike(String keyword);

	List<Textbook> findByTitleLikeOrderByAsc(String keyword);

	Object findOneById(Integer textbookId);


}
