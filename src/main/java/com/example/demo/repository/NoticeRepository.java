package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

	List<Notice> findByUserId(Integer id);

	List<Notice> findByUserIdAndNoticeStatus(Integer id, Integer noticeStatus);	//特定のユーザー向けかつ特定の状態の通知をすべて取得

}
