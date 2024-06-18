package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lessons")
public class Lesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer day;
	private Integer period;
	@Column(name="teacher_id")
	private Integer teacherId;
	
	public Lesson() {
	}
	
	public Lesson(String name, Integer day, Integer period, Integer teacherId) {
		this.name = name;
		this.day = day;
		this.period = period;
		this.teacherId = teacherId;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getDay() {
		return day;
	}

	public Integer getPeriod() {
		return period;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

}