package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "timetables")
public class Timetables {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id; //時間割ID

@Column(name = "lesson_id")
private Integer lessonId; //授業ID

@Column(name = "user_id")
private Integer userId; //会員ID

public Timetables() {
}

public Timetables(Integer lessonId,Integer userId) {
	this.lessonId=lessonId;
	this.userId=userId;
}

public Integer getId() {
	return id;
}

public Integer getLessonId() {
	return lessonId;
}

public Integer getUserId() {
	return userId;
}



}


