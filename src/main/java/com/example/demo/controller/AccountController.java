package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	//ログイン画面の表示
	@GetMapping("/")
	public String index() {
		session.invalidate();
		return "login";
	}

	//ログイン処理
	@PostMapping("/")
	public String login(
			@RequestParam(name = "studentNumber", defaultValue = "") Integer studentNumber,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		//エラーチェック
		List<String> errorList = new ArrayList<>();
		if (studentNumber == null) {
			errorList.add("学籍番号は必須です");
		}

		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		} else if (password.length() < 8) {
			errorList.add("パスワードは8文字以上です");
		}
		User user = userRepository.findByStudentNumberAndPassword(studentNumber, password);
		if (account == null) {
			errorList.add("学籍番号もしくはパスワードが間違っています");

		}
		if (errorList.size() == 0) {
			model.addAttribute("errorList", errorList);
			return "login";
		}
		account.setId(account.getId());
		account.setUserStatus(account.getUserStatus());
		return "";
	}

	@GetMapping("/account")
	public String view(Model model) {
		return "mypage";
	}

	@GetMapping("/account/setPassword")
	public String setPassword() {
		return "setPassword";
	}

	@PostMapping("/account/setPassword")
	public String setPassword(
			@RequestParam(name = "oldPassword", defaultValue = "") String oldPassword,
			@RequestParam(name = "newPassword", defaultValue = "") String newPassword,
			@RequestParam(name = "reNewPassword", defaultValue = "") String reNewPassword) {
		User user = userRepository.findById(account.getId()).get();
		return "mypage";
	}

	@GetMapping("/account/setIntroduce")
	public String resetIntroduce(Model model) {
		return "resetIntroduce";
	}

	@PostMapping("/account/setIntroduce")
	public String setIntroduce(
			@RequestParam(name = "introduce", defaultValue = "") String introduce) {
		return "mypage";
	}

}
