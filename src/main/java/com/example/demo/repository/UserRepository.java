package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByStudentNumberAndPassword(Integer studentNumber, String password);

	User findOneById(Integer buyerId);

	List<User> findByStudentNumberLike(String number);

}
