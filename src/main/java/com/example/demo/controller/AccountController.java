package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.Timetable;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.LessonRepository;
import com.example.demo.repository.TextbookRepository;
import com.example.demo.repository.TimetableRepository;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemImageRepository itemImageRepository;

	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	TimetableRepository timetableRepository;

	@Autowired
	LessonRepository lessonRepository;

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
			@RequestParam(name = "personalNumber", defaultValue = "") String personalNumber,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		//エラーチェック

		List<String> errorList = new ArrayList<>();

		List<User> userList = userRepository.findByPersonalNumberAndPassword(personalNumber, password);

		//個人番号未入力時のエラー
		if (personalNumber.length() == 0) {
			errorList.add("個人番号は必須です");

		}
		//パスワード未入力時のエラー	
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");

			//正しくない個人番号またはパスワード入力時のエラー
		} else if (userList.size() == 0 || userList == null) {
			errorList.add("個人番号もしくはパスワードが正しくありません");
		}

		//エラーメッセージの出力
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("personalNumber", personalNumber);
			model.addAttribute("password", password);
			return "login";
		}

		User user = userList.get(0);
		account.setId(user.getId());
		account.setUserStatus(user.getUserStatus());

		return "redirect:/home";
	}

	@GetMapping("/account")
	public String view(Model model) {
		//ユーザーを検索して情報を送信
		User user = userRepository.findById(account.getId()).get();
		model.addAttribute("user", user);
		//注文を降順にリスト化する
		List<Item> sellList = itemRepository.findBySellerIdOrderByIdDesc(account.getId());
		List<Item> buyList = itemRepository.findByBuyerIdOrderByIdDesc(account.getId());
		//imgpathを格納するStringの箱を作る
		List<Textbook> textbookList = new ArrayList<>();
		List<ItemImage> imgList = new ArrayList<>();
		List<ItemImage> imgList2 = new ArrayList<>();
		List<ItemImage> getimg1;
		List<ItemImage> getimg2;

		//上記二つに全部の要素をぶち込む
		textbookList = textbookRepository.findAll();
		for (Item buyItem : buyList) {
			//その中から一つの情報を得るための箱を作る
			ItemImage img1 = new ItemImage();
			//アイテムイメージをアイテムIDで検索をかけて入れる
			getimg1 = itemImageRepository.findByItemId(buyItem.getId());
			//その中から一つだけを取り出す
			img1 = getimg1.get(0);
			//一つの結果をリストに入れていく
			imgList.add(img1);
		}
		for (Item sellItem : sellList) {
			ItemImage img2 = new ItemImage();
			getimg2 = itemImageRepository.findByItemId(sellItem.getId());
			img2 = getimg2.get(0);
			imgList2.add(img2);
		}

		Integer countbuyList = buyList.size();
		Integer countsellList = sellList.size();

		//時間割テーブルからログイン中のユーザに関する時間割 (授業)を参照
		List<Timetable> timetableList = timetableRepository.findByUserId(account.getId());

		//36の時間割初期化
		Lesson class11 = null;
		Lesson class12 = null;
		Lesson class13 = null;
		Lesson class14 = null;
		Lesson class15 = null;
		Lesson class16 = null;
		Lesson class21 = null;
		Lesson class22 = null;
		Lesson class23 = null;
		Lesson class24 = null;
		Lesson class25 = null;
		Lesson class26 = null;
		Lesson class31 = null;
		Lesson class32 = null;
		Lesson class33 = null;
		Lesson class34 = null;
		Lesson class35 = null;
		Lesson class36 = null;
		Lesson class41 = null;
		Lesson class42 = null;
		Lesson class43 = null;
		Lesson class44 = null;
		Lesson class45 = null;
		Lesson class46 = null;
		Lesson class51 = null;
		Lesson class52 = null;
		Lesson class53 = null;
		Lesson class54 = null;
		Lesson class55 = null;
		Lesson class56 = null;
		Lesson class61 = null;
		Lesson class62 = null;
		Lesson class63 = null;
		Lesson class64 = null;
		Lesson class65 = null;
		Lesson class66 = null;
		//月曜1限目
		for (Timetable timetable : timetableList) {
			class11 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 1, 1);
			if (class11 != null) {
				break;
			}
		}

		//月曜2限目
		for (Timetable timetable : timetableList) {
			class12 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 1, 2);
			if (class12 != null) {
				break;
			}
		}
		//月曜3限目
		for (Timetable timetable : timetableList) {
			class13 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 1, 3);
			if (class13 != null) {
				break;
			}
		}
		//月曜4限目
		for (Timetable timetable : timetableList) {
			class14 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 1, 4);
			if (class14 != null) {
				break;
			}
		}
		//月曜5限目
		for (Timetable timetable : timetableList) {
			class15 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 1, 5);
			if (class15 != null) {
				break;
			}
		}
		//月曜6限目
		for (Timetable timetable : timetableList) {
			class16 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 1, 6);
			if (class16 != null) {
				break;
			}
		}
		//火曜1限目
		for (Timetable timetable : timetableList) {
			class21 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 2, 1);
			if (class21 != null) {
				break;
			}
		}
		//火曜2限目
		for (Timetable timetable : timetableList) {
			class22 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 2, 2);
			if (class22 != null) {
				break;
			}
		}
		//火曜3限目
		for (Timetable timetable : timetableList) {
			class23 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 2, 3);
			if (class23 != null) {
				break;
			}
		}
		//火曜4限目
		for (Timetable timetable : timetableList) {
			class24 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 2, 4);
			if (class24 != null) {
				break;
			}
		}
		//火曜5限目
		for (Timetable timetable : timetableList) {
			class25 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 2, 5);
			if (class25 != null) {
				break;
			}
		}
		//火曜6限目
		for (Timetable timetable : timetableList) {
			class26 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 2, 6);
			if (class26 != null) {
				break;
			}
		}
		//水曜1限目
		for (Timetable timetable : timetableList) {
			class31 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 3, 1);
			if (class31 != null) {
				break;
			}
		}
		//水曜2限目
		for (Timetable timetable : timetableList) {
			class32 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 3, 2);
			if (class32 != null) {
				break;
			}
		}
		//水曜3限目
		for (Timetable timetable : timetableList) {
			class33 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 3, 3);
			if (class33 != null) {
				break;
			}
		}
		//水曜4限目
		for (Timetable timetable : timetableList) {
			class34 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 3, 4);
			if (class34 != null) {
				break;
			}
		}
		//水曜5限目
		for (Timetable timetable : timetableList) {
			class35 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 3, 5);
			if (class35 != null) {
				break;
			}
		}
		//水曜6限目
		for (Timetable timetable : timetableList) {
			class36 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 3, 6);
			if (class36 != null) {
				break;
			}
		}
		//木曜1限目
		for (Timetable timetable : timetableList) {
			class41 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 4, 1);
			if (class41 != null) {
				break;
			}
		}
		//木曜2限目
		for (Timetable timetable : timetableList) {
			class42 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 4, 2);
			if (class42 != null) {
				break;
			}
		}
		//木曜3限目
		for (Timetable timetable : timetableList) {
			class43 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 4, 3);
			if (class43 != null) {
				break;
			}
		}
		//木曜4限目
		for (Timetable timetable : timetableList) {
			class44 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 4, 4);
			if (class44 != null) {
				break;
			}
		}
		//木曜5限目
		for (Timetable timetable : timetableList) {
			class45 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 4, 5);
			if (class45 != null) {
				break;
			}
		}
		//木曜6限目
		for (Timetable timetable : timetableList) {
			class46 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 4, 6);
			if (class46 != null) {
				break;
			}
		}
		//金曜1限目
		for (Timetable timetable : timetableList) {
			class51 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 5, 1);
			if (class51 != null) {
				break;
			}
		}
		//金曜2限目
		for (Timetable timetable : timetableList) {
			class52 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 5, 2);
			if (class52 != null) {
				break;
			}
		}
		//金曜3限目
		for (Timetable timetable : timetableList) {
			class53 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 5, 3);
			if (class53 != null) {
				break;
			}
		}
		//金曜4限目
		for (Timetable timetable : timetableList) {
			class54 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 5, 4);
			if (class54 != null) {
				break;
			}
		}
		//金曜5限目
		for (Timetable timetable : timetableList) {
			class55 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 5, 5);
			if (class55 != null) {
				break;
			}
		}
		//金曜6限目
		for (Timetable timetable : timetableList) {
			class56 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 5, 6);
			if (class56 != null) {
				break;
			}
		}
		//土曜1限目
		for (Timetable timetable : timetableList) {
			class61 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 6, 1);
			if (class61 != null) {
				break;
			}
		}
		//土曜2限目
		for (Timetable timetable : timetableList) {
			class62 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 6, 2);
			if (class62 != null) {
				break;
			}
		}
		//土曜3限目
		for (Timetable timetable : timetableList) {
			class63 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 6, 3);
			if (class63 != null) {
				break;
			}
		}
		//土曜4限目
		for (Timetable timetable : timetableList) {
			class64 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 6, 4);
			if (class64 != null) {
				break;
			}
		}
		//土曜5限目
		for (Timetable timetable : timetableList) {
			class65 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 6, 5);
			if (class65 != null) {
				break;
			}
		}
		//土曜6限目
		for (Timetable timetable : timetableList) {
			class66 = (Lesson) lessonRepository.findByIdAndDayAndPeriod(timetable.getLessonId(), 6, 6);
			if (class66 != null) {
				break;
			}
		}

		model.addAttribute("textbookList", textbookList);
		model.addAttribute("imgList", imgList);
		model.addAttribute("imgList2", imgList2);
		model.addAttribute("buyList", buyList);
		model.addAttribute("sellList", sellList);
		model.addAttribute("countsellList", countsellList);
		model.addAttribute("countbuyList", countbuyList);

		//36の時間割
		model.addAttribute("class11", class11);
		model.addAttribute("class12", class12);
		model.addAttribute("class13", class13);
		model.addAttribute("class14", class14);
		model.addAttribute("class15", class15);
		model.addAttribute("class16", class16);
		model.addAttribute("class21", class21);
		model.addAttribute("class22", class22);
		model.addAttribute("class23", class23);
		model.addAttribute("class24", class24);
		model.addAttribute("class25", class25);
		model.addAttribute("class26", class26);
		model.addAttribute("class31", class31);
		model.addAttribute("class32", class32);
		model.addAttribute("class33", class33);
		model.addAttribute("class34", class34);
		model.addAttribute("class35", class35);
		model.addAttribute("class36", class36);
		model.addAttribute("class41", class41);
		model.addAttribute("class42", class42);
		model.addAttribute("class43", class43);
		model.addAttribute("class44", class44);
		model.addAttribute("class45", class45);
		model.addAttribute("class46", class46);
		model.addAttribute("class51", class51);
		model.addAttribute("class52", class52);
		model.addAttribute("class53", class53);
		model.addAttribute("class54", class54);
		model.addAttribute("class55", class55);
		model.addAttribute("class56", class56);
		model.addAttribute("class61", class61);
		model.addAttribute("class62", class62);
		model.addAttribute("class63", class63);
		model.addAttribute("class64", class64);
		model.addAttribute("class65", class65);
		model.addAttribute("class66", class66);

		//mypage表示
		return "mypage";
	}

	@GetMapping("/account/setPassword")
	public String resetPassword() {
		return "setPassword";
	}

	@PostMapping("/account/setPassword")
	public String setPassword(
			@RequestParam(name = "oldPassword", defaultValue = "") String oldPassword,
			@RequestParam(name = "newPassword", defaultValue = "") String newPassword,
			@RequestParam(name = "reNewPassword", defaultValue = "") String reNewPassword,
			Model model) {
		//idでuserを検索
		User user = userRepository.findById(account.getId()).get();
		//errorListでエラーを格納
		List<String> errorList = new ArrayList<>();
		//古いパスワードの入力検査
		//未入力をはじく処理とパスワードが違っていた場合の処理
		if (oldPassword.length() == 0) {
			errorList.add("パスワードは必須です");
		} else if (!(oldPassword.equals(user.getPassword()))) {
			errorList.add("パスワードが間違っています");
		}
		//新しいパスワードの入力検査
		//未入力をはじく処理と文字数不足を検査する処理
		if (newPassword.length() == 0) {
			errorList.add("新しいパスワードは必須です");
		} else if (newPassword.length() < 8) {
			errorList.add("パスワードは８文字以上必要です");
		}
		//確認用パスワードの入力検査
		//未入力をはじく処理と新しいパスワードとの一致を検査する処理
		if (reNewPassword.length() == 0) {
			errorList.add("確認用パスワードは必須です");
		} else if (!(newPassword.equals(reNewPassword))) {
			errorList.add("新しいパスワードと確認用パスワードが一致しません");
		}
		//エラーリストの中身があるか判定
		if (errorList.size() != 0) {
			//あった場合、errorListを渡してsetpasswordに飛ぶ
			model.addAttribute("errorList", errorList);
			return "setPassword";
		} else {
			//なかった場合、userに新しいパスワードをセットし
			user.setPassword(newPassword);
		}
		//userをDBに保存する。
		userRepository.save(user);

		return "redirect:/account";

	}

	@GetMapping("/account/setIntroduce")
	//自己紹介更新ページの表示
	public String resetIntroduce(Model model) {
		//idでuserを検索
		User user = userRepository.findById(account.getId()).get();
		//検索したユーザーの個人番号を送信
		model.addAttribute("personalNumber", user.getPersonalNumber());
		//検索したユーザーの自己紹介メッセージを送信
		model.addAttribute("introduce", user.getIntroduce());
		//自己紹介更新ページを開く
		return "resetIntroduce";
	}

	@PostMapping("/account/setIntroduce")
	public String setIntroduce(
			@RequestParam(name = "introduce", defaultValue = "") String introduce) {
		//自己紹介は無記入可能であるため、エラー処理不要
		User user = userRepository.findById(account.getId()).get();
		//idで検索をかけたuserに新しい自己紹介を入れる
		user.setIntroduce(introduce);
		//自己紹介を更新したuserをほぞん
		userRepository.save(user);
		return "redirect:/account";
	}

}
