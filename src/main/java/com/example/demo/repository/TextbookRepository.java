package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Textbook;

public interface TextbookRepository extends JpaRepository<Textbook, Integer> {

	Textbook findOneById(Integer textbookId); //該当のIDの教科書の情報を取得

	List<Textbook> findByTitle(String title); //該当のタイトルの教科書の情報を取得

	List<Textbook> findByTitleContainingOrderByIdAsc(String keyword); //指定されたキーワードを含むタイトルを持つ教科書の情報を取得
}
