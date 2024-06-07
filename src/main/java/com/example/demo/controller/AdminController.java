package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.TextbookRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ClaimRepository claimRepository;

	@Autowired
	ItemImageRepository itemImageRepository;

	//管理者画面を表示
	@GetMapping("/admin")
	public String index() {
		return "admin/admin";
	}

	//出品申請一覧管理画面を表示
	@GetMapping("/admin/request")
	public String requestList(Model model) {
		model.addAttribute("items", itemRepository.findAll());
		model.addAttribute("textbooks", textbookRepository.findAll());
		model.addAttribute("users", userRepository.findAll());
		return "admin/request";
	}

	//商品IDをもとに該当の申請詳細画面を表示
	@GetMapping("/admin/request/{id}")
	public String viewItem(
			@PathVariable("id") Integer id,
			Model model) {
		Item item = itemRepository.findOneById(id);
		model.addAttribute("item", item);
		model.addAttribute("textbook", textbookRepository.findOneById(item.getTextbookId()));
		model.addAttribute("images", itemImageRepository.findByItemId(id));
		model.addAttribute("user", userRepository.findOneById(item.getSellerId()));
		return "admin/item";
	}

	//商品IDと選択された状態をもとに商品情報の更新処理
	@PostMapping("/admin/request/{id}")
	public String setStatus(
			@PathVariable("id") Integer id,
			@RequestParam("status") Integer status) {
		Item item = itemRepository.findOneById(id);
		
		
		return "redirect:/admin/request";
	}

}
