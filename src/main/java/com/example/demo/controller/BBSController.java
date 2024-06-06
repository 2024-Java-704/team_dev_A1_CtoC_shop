package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BBSController {

	//募集一覧画面を表示
	@GetMapping("/bbs")
	public String index(Model model) {
		return "";
	}

	//募集追加の画面を表示
	@GetMapping("/bbs/addRequest")
	public String addRequest() {
		return "";
	}

	//募集追加の処理
	@PostMapping("/bbs/addRequest")
	public String sendRequest(
			@RequestParam(name = "id") Integer id,
			@RequestParam(name = "itemStatus") Integer itemStatus) {
		return "";
	}

	//募集の削除処理
	@PostMapping("/bbs/delete/{id}")
	public String deleteRequest(@PathVariable("id") Integer id) {
		return "";
	}

}
