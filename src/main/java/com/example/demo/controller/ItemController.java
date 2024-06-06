package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemRepository;

public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	Account account;

	@GetMapping("/home")
	public String textList(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Item> ItemList = null;
		Integer buyerId = account.getId();
		
		return "home";
	}
}