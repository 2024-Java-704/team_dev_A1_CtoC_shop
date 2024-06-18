package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Request;
import com.example.demo.entity.Textbook;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.TextbookRepository;

@Controller
public class BBSController {

	@Autowired
	RequestRepository requestRepository;

	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	Account account;

	//募集一覧画面を表示
	@GetMapping("/bbs")
	public String index(Model model) {
		//教科書の一覧を取得
		List<Textbook> textbookList = textbookRepository.findAll();
		model.addAttribute("titles", textbookList);
		//募集されている教科書の一覧を取得
		List<Request> requestList = requestRepository.findAll();
		model.addAttribute("requests", requestList);
		
		return "bbsTable";
	}

	//募集追加の画面を表示
	@GetMapping("/bbs/addRequest")
	public String addRequest(
			@RequestParam(name = "title", defaultValue = "") String title,
			Model model) {
		//教科書の一覧を取得
		List<Textbook> textbookList = textbookRepository.findAll();
		model.addAttribute("title", textbookList);

		return "addRequest";
	}

	//募集追加の処理
	@PostMapping("/bbs/addRequest")
	public String sendRequest(
			@RequestParam(name = "title", defaultValue = "") Integer id,
			@RequestParam(name = "item_status", defaultValue = "") Integer item_status) {
		//Requestオブジェクトの生成
		Request request = new Request(account.getId(), id, item_status);
		//requestsテーブルへの反映
		requestRepository.save(request);
		return "redirect:/bbs";
	}

	//募集の削除処理
	@PostMapping("/bbs/{id}/delete")
	public String deleteRequest(@PathVariable("id") Integer id) {
		requestRepository.deleteById(id); //Repository内のIDを検索する
		return "redirect:/bbs";
	}

}