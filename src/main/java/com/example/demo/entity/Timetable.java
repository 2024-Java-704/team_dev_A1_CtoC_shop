package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "timetables")
public class Timetable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="lesson_id")
	private Integer lessonId;
	@Column(name="user_id")
	private Integer userId;
	
	public Timetable() {
	}
	
	public Timetable(Integer lessonId, Integer userId) {
		this.lessonId = lessonId;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public Integer getLessonId() {
		return lessonId;
	}
	
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public Integer getUserId() {
		return userId;
	}
	
}