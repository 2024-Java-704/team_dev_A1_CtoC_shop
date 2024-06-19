package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Claim;
import com.example.demo.entity.Notice;
import com.example.demo.model.Account;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.NoticeRepository;

@Controller
public class MessageController {

	@Autowired
	NoticeRepository noticeRepository;
	
	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	Account account;

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

		// エラーチェック
		List<String> errorList = new ArrayList<>();
		if (message.length() == 0) {
			errorList.add("入力してください");
		}

		// エラー発生時はお問い合わせフォームに戻す
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("message", message);
			return "contactForm";
		}
		//Claimオブジェクトの生成
		Claim claim = new Claim(message);
		//claimsテーブルへの反映
		claimRepository.save(claim);

		return "redirect:/home";
	}

	// 通知画面の表示
	@GetMapping("/Notice")
	public String Notice(Model model) {
		//ログインしているユーザーの情報を取得
		List<Notice> noticeList = noticeRepository.findByUserId(account.getId());
		//通知を一つずつ処理
		for (Notice notice : noticeList) {
			//通知を既読状態にする
			notice.setNoticeStatus(2);
			//noticesテーブルへの反映
			noticeRepository.save(notice);
		}
		
		model.addAttribute("notices", noticeList);

		return "notification";
	}
}
