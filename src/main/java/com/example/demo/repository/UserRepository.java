package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByPersonalNumberAndPassword(String personalNumber, String password);

	User findOneByPersonalNumberAndPassword(String personalNumber, String password);

	User findOneById(Integer buyerId);	//特定のIDのユーザー情報を取得

	List<User> findByPersonalNumberContaining(String number);	//指定の文字を含む個人番号を持つユーザー情報をすべて取得

	List<User> findByUserStatus(Integer userStatus);

	List<User> findByPersonalNumberContainingAndUserStatus(String number, Integer userStatus);

}
