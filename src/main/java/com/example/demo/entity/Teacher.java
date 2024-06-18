package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	private String personalNumber;

	private LocalDate birthday;

	private String address;

	private String number;

	private String faculty;

	private String department;

	public Teacher() {
	}

	public String getName() {
		return name;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getAddress() {
		return address;
	}

	public String getNumber() {
		return number;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getDepartment() {
		return department;
	}

}
