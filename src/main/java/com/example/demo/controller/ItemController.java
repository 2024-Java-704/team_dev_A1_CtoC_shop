package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Textbook;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.TextbookRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	Account account;

	@GetMapping("/home")
	public String textList(

			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Textbook> itemList = null;
		
		if(keyword.length()==0 ||keyword.equals(null)) {
			itemList=textbookRepository.findAll();
		}else {
			itemList=textbookRepository.findByNameLike(keyword);
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("itemList", itemList);
		return "home";
	}
}