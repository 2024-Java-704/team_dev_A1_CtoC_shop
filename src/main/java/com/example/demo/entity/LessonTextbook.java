package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lesson_textbooks")
public class LessonTextbook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="lesson_id")
	private Integer lessonId;
	@Column(name="textbook_id")
	private Integer textbookId;
	
	public LessonTextbook() {
	}
	
	public LessonTextbook(Integer lessonId, Integer textbookId) {
		this.lessonId = lessonId;
		this.textbookId = textbookId;
	}

	public Integer getId() {
		return id;
	}

	public Integer getLessonId() {
		return lessonId;
	}

	public Integer getTextbookId() {
		return textbookId;
	}
	
}