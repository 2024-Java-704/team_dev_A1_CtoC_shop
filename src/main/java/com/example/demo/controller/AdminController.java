package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Claim;
import com.example.demo.entity.Item;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.User;
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
		item.setDealStatus(status);

		return "redirect:/admin/request";
	}

	@GetMapping("/admin/user")
	public String userList(
			@RequestParam(name = "number", defaultValue = "") String number,
			Model model) {
		List<User> users;

		if (number.equals(""))
			users = userRepository.findAll();
		else
			users = userRepository.findByStudentNumberLike(number);

		model.addAttribute("users", users);

		return "admin/user";
	}

	@PostMapping("/admin/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);

		return "redirect:/admin/user";
	}

	@GetMapping("/admin/claim")
	public String claimList(Model model) {
		List<Claim> claims = claimRepository.findByOrderById();

		for (Claim claim : claims) {
			claim.setClaimStatus(2);
			claimRepository.save(claim);
		}

		claims = claimRepository.findByOrderByIdAsc();
		model.addAttribute("claims", claims);

		return "admin/claim";
	}

	@GetMapping("/admin/addTextbook")
	public String addTextbook() {
		return "admin/addTextbook";
	}

	@PostMapping("/admin/addTextbook")
	public String sendTextbook(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "price", defaultValue = "") Integer price,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			Model model) {

		if (title.equals("") || author.equals("") || price.equals("") || publisher.equals("")) {
			String msg = "";

			if (title.equals(""))
				msg += "<p>タイトルが入力されていません</p>";
			if (author.equals(""))
				msg += "<p>著者が入力されていません</p>";
			if (price.equals(""))
				msg += "<p>価格が設定されていません</p>";
			if (publisher.equals(""))
				msg += "<p>出版社が入力されていません</p>";

			model.addAttribute("msg", msg);
			return "admin/addTextbook";
		}

		Textbook textbook = new Textbook(title, author, price, publisher);
		textbookRepository.save(textbook);

		return "redirect:/admin/claim";
	}

}
