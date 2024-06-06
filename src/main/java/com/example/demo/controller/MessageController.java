package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MessageController {
	// お問い合わせ画面の表示
	@GetMapping("/claim")
	public String addClaim() {
		return "contactForm";
	}

	// お問い合わせメッセージ送信処理
	@PostMapping("/claim")
	public String sendClaim(
			@RequestParam(name = "message", defaultValue = "") String message,
			Model model) {

		model.addAttribute("message", message);

		return "home";
	}
	
	// 通知画面の表示
	@GetMapping("/Notice")
	public String notice() {
		return "notification";
	}
}
