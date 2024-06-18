package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LessonTextbook;

public interface LessonTextbookRepository extends JpaRepository<LessonTextbook, Integer> {
	
	LessonTextbook findOneById(Integer id);
	
	List<LessonTextbook> findByLessonId(Integer lessonId);
	
}
