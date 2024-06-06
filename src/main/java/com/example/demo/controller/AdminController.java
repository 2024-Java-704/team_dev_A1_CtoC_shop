package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.repository.TextbookRepository;

@Controller
public class AdminController {
	
	@Autowired
	TextbookRepository textbookRepository;
	
	//管理者画面を表示
	@GetMapping("/admin") 
	public String index() {
		return "admin/admin";
	}
	
	//出品申請一覧管理画面を表示
	@GetMapping("/admin/request")
	public String requestList(Model model) {
		return "admin/request";
	}
	
	//商品IDをもとに該当の申請詳細画面を表示
	@GetMapping("/admin/request/{id}")
	public String viewItem(
			@PathVariable("id")Integer id,
			Model model) {
		return "admin/item";
	}

}
