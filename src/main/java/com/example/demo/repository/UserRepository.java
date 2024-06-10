package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByStudentNumberAndPassword(String studentNumber, String password);

	User findOneByStudentNumberAndPassword(String studentNumber, String password);

	User findOneById(Integer buyerId);	//特定のIDのユーザー情報を取得

	List<User> findByStudentNumberContaining(String number);	//指定の文字を含む学籍番号を持つユーザー情報をすべて取得

}
