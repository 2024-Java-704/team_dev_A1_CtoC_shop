package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Textbook;

public interface TextbookRepository extends JpaRepository<Textbook, Integer>{

}
