package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Textbook;
import com.example.demo.repository.BBSRepository;
import com.example.demo.repository.TextbookRepository;

@Controller
public class BBSController {

	@Autowired
	BBSRepository bBSRepository;

	@Autowired
	TextbookRepository textbookRepository;

	//募集一覧画面を表示
	@GetMapping("/bbs")
	public String index(Model model) {
		return "bbsTable";
	}

	//募集追加の画面を表示
	@GetMapping("/bbs/addRequest")
	public String addRequest(
			Model model) {
		List<Textbook> textbookList = textbookRepository.findAll();
		model.addAttribute("title", textbookList);
		return "addRequest";
	}

	//募集追加の処理
	@PostMapping("/bbs/addRequest")
	public String sendRequest(
			@RequestParam(name = "id", defaultValue = "") Integer id,
			@RequestParam(name = "itemStatus", defaultValue = "") Integer itemStatus) {
		//		Textbook textbook = new textbook(id, itemStatus);
		//		textbookRepository.save(textbook);
		return "bbsTable";
	}

	//募集の削除処理
	@PostMapping("/bbs/delete/{id}")
	public String deleteRequest(@PathVariable("id") Integer id) {
		return "bbsTable";
	}

}