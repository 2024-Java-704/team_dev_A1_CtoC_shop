package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Claim;
import com.example.demo.entity.History;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.LessonTextbook;
import com.example.demo.entity.Notice;
import com.example.demo.entity.Request;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.LessonRepository;
import com.example.demo.repository.LessonTextbookRepository;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.repository.RequestRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TextbookRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	Account account;

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

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	RequestRepository requestRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	LessonRepository lessonRepository;

	@Autowired
	LessonTextbookRepository lessonTextbookRepository;

	@Autowired
	HistoryRepository historyRepository;

	//管理者画面を表示
	@GetMapping("/admin")
	public String index(Model model) {
		model.addAttribute("requestCount", itemRepository.findByDealStatus(1).size());
		return "admin/admin";
	}

	//出品申請一覧管理画面を表示
	@GetMapping("/admin/request")
	public String requestList(Model model) {
		List<Item> items = itemRepository.findByDealStatus(1);
		if (items.size() > 0) {
			model.addAttribute("items", items);
		}
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
		List<ItemImage> images = itemImageRepository.findByItemId(id);
		model.addAttribute("item", item);
		model.addAttribute("textbook", textbookRepository.findOneById(item.getTextbookId()));
		model.addAttribute("images", images);
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
		itemRepository.save(item);
		if (status == 2) {
			noticeRepository.save(new Notice(item.getSellerId(),
					"「" + textbookRepository.findOneById(item.getTextbookId()).getTitle() + "」の出品申請が不許可になりました"));
		}
		if (status == 3) {
			noticeRepository.save(new Notice(item.getSellerId(),
					"「" + textbookRepository.findOneById(item.getTextbookId()).getTitle() + "」の出品申請が承認されました!"));

			List<Request> requests = requestRepository.findByTextbookId(item.getTextbookId());
			for (Request request : requests) {
				if (request.getItemStatus() == 5 || request.getItemStatus() == item.getItemStatus()) {
					noticeRepository.save(new Notice(request.getUserId(),
							"「" + textbookRepository.findOneById(item.getTextbookId()).getTitle() + "」が出品されました!"));
				}
			}

			List<History> histories = historyRepository.findByTextbookIdAndStatus(item.getTextbookId(), 1);
			for (History history : histories) {
				noticeRepository.save(new Notice(history.getUserId(),
						"「" + textbookRepository.findOneById(item.getTextbookId()).getTitle() + "」が出品されました!"));
			}
		}

		return "redirect:/admin/request";
	}

	//ユーザー管理画面を表示
	@GetMapping("/admin/user")
	public String userList(
			@RequestParam(name = "number", defaultValue = "") String number,
			Model model) {
		List<User> users;

		if (number.equals(""))
			users = userRepository.findByUserStatus(2);
		else {
			users = userRepository.findByPersonalNumberContainingAndUserStatus(number, 2);
			model.addAttribute("number", number);
		}

		users.remove(userRepository.findOneById(1));

		if (users.size() > 0)
			model.addAttribute("users", users);

		model.addAttribute("students", studentRepository.findAll());

		return "admin/user";
	}

	//会員IDをもとに該当の会員の削除処理
	@PostMapping("/admin/user/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);

		return "redirect:/admin/user";
	}

	//問い合わせメッセージの一覧を表示
	@GetMapping("/admin/claim")
	public String claimList(Model model) {

		List<Claim> claims = new ArrayList<Claim>();
		List<Claim> claimList = claimRepository.findByOrderByIdDesc();

		for (Claim claim : claimList) {
			Claim c = new Claim(claim.getId(), claim.getMessage(), claim.getClaimStatus());
			claims.add(c);
		}

		model.addAttribute("claims", claims);

		claimList = claimRepository.findByOrderById();

		for (Claim claim : claimList) {
			claim.setClaimStatus(2);
			claimRepository.save(claim);
		}

		return "admin/claim";
	}

	//新規教科書追加画面を表示
	@GetMapping("/admin/addTextbook")
	public String addTextbook() {
		return "admin/addTextbook";
	}

	//教科書の追加処理
	@PostMapping("/admin/addTextbook")
	public String sendTextbook(
			@RequestParam(name = "title", defaultValue = "") String title,
			@RequestParam(name = "author", defaultValue = "") String author,
			@RequestParam(name = "price", defaultValue = "") Integer price,
			@RequestParam(name = "publisher", defaultValue = "") String publisher,
			Model model) {

		if (title.equals("") || author.equals("") || price < 1 || publisher.equals("")) {
			String msg = "";

			if (title.equals(""))
				msg += "<p>タイトルが入力されていません</p>";
			if (author.equals(""))
				msg += "<p>著者が入力されていません</p>";
			if (price < 1)
				msg += "<p>価格が設定されていません</p>";
			if (publisher.equals(""))
				msg += "<p>出版社が入力されていません</p>";

			model.addAttribute("msg", msg);
			model.addAttribute("title", title);
			model.addAttribute("author", author);
			model.addAttribute("price", price);
			model.addAttribute("publisher", publisher);
			return "admin/addTextbook";
		}

		Textbook textbook = new Textbook(title, author, price, publisher);
		textbookRepository.save(textbook);

		return "redirect:/admin/addTextbook";
	}

	//新規授業追加画面を表示
	@GetMapping("/admin/addLesson")
	public String addLesson(Model model) {

		model.addAttribute("textbooks", textbookRepository.findAll());

		return "admin/addLesson";
	}

	//新規授業追加処理
	@PostMapping("/admin/addLesson")
	public String sendLesson(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "day", defaultValue = "") Integer day,
			@RequestParam(name = "period", defaultValue = "") Integer period,
			@RequestParam(name = "textbooks", defaultValue = "") Integer[] textbooks,
			Model model) {

		int count = 0;
		if (textbooks.length > 1) {
			for (int i = 0; i < textbooks.length - 1; i++) {
				for (int j = i + 1; j < textbooks.length; j++) {
					if (textbooks[i] == textbooks[j] && textbooks[i] != 0)
						count++;
				}
			}
		}

		if (name.equals("") || count > 0) {
			String msg = "";

			if (name.equals(""))
				msg += "<p>授業名が入力されていません</p>";
			if (count > 0)
				msg += "<p>同じ教科書が選択されています</p>";

			model.addAttribute("name", name);
			model.addAttribute("day", day);
			model.addAttribute("period", period);
			model.addAttribute("textbooks", textbookRepository.findAll());

			model.addAttribute("msg", msg);

			return "admin/addLesson";
		}
		Lesson lesson = new Lesson(name, day, period, account.getId());
		lessonRepository.save(lesson);

		if (textbooks.length > 0) {
			for (Integer textbookId : textbooks) {
				if (textbookId != 0) {
					LessonTextbook lessonTextbook = new LessonTextbook(lesson.getId(), textbookId);
					lessonTextbookRepository.save(lessonTextbook);
				}
			}
		}

		return "redirect:/admin";
	}

}
