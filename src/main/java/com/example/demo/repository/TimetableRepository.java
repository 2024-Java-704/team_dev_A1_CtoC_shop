package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Integer> {
	
	Timetable findOneById(Integer id);
	
	List<Timetable> findByUserId(Integer UserId);

	Timetable findOneByLessonIdAndUserId(Integer lessonId, Integer userId);
}
