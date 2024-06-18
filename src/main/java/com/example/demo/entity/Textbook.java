package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "textbooks")
public class Textbook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String author;

	private Integer price;

	private String publisher;

	@Transient
	private String textimg;

	public Textbook() {
	}

	public Textbook(String title, String author, Integer price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getPrice() {
		return price;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getTextimg() {
		return textimg;
	}

	public void setTextimg(String textimg) {
		this.textimg = textimg;
	}

	public String getTextbookUrl() {
		return "<a href='/home?keyword=" + title + "'>" + title + "</a>";
	}

}
