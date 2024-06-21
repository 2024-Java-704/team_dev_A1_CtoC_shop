package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
	
	Lesson findOneById(Integer id);
	
	List<Lesson> findByDayAndPeriod(Integer day, Integer Period);

	Lesson findByIdAndDayAndPeriod(Integer lessonId, Integer day, Integer Period);

	List<Lesson> findByOrderByDayAscPeriodAsc();
}
