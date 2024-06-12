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
import com.example.demo.entity.Textbook;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.TextbookRepository;
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
			@RequestParam(name = "studentNumber", defaultValue = "") String studentNumber,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {

		//エラーチェック

		List<String> errorList = new ArrayList<>();

		List<User> userList = userRepository.findByStudentNumberAndPassword(studentNumber, password);

		//学籍番号入力時のエラー
		if (studentNumber.length() == 0) {
			errorList.add("学籍番号は必須です");

			//パスワード入力時のエラー	
		} else if (password.length() == 0) {
			errorList.add("パスワードは必須です");

			//	正しくない学籍番号またはパスワード入力時のエラー
		} else if (userList.size() == 0 || userList == null) {
			errorList.add("学籍番号もしくはパスワードが正しくありません");
		}

		//エラーメッセージの出力
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("studentNumber", studentNumber);
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
		List<Item>sellList = itemRepository.findBySellerIdOrderByIdDesc(account.getId());
		List<Item> buyList = itemRepository.findByBuyerIdOrderByIdDesc(account.getId());
		//imgpathを格納するStringの箱を作る
		List<Textbook> textbookList = new ArrayList<>();
		List<ItemImage> imgList = new ArrayList<>();
		List<ItemImage> imgList2 = new ArrayList<>();

		//上記二つに全部の要素をぶち込む
		textbookList = textbookRepository.findAll();
		for (Item buyItem : buyList) {
			imgList.add(itemImageRepository.findOneByItemId(buyItem.getId()));
		}
		for (Item sellItem : sellList) {
			imgList2.add(itemImageRepository.findOneByItemId(sellItem.getId()));
		}
		System.out.println();
		System.out.println(buyList.size());
		Integer countbuyList=buyList.size();
		Integer countsellList=sellList.size();

		//		//要素を引っ張り出してリスト化するだけですむようにします
		//		List<String>textname=new ArrayList<>();
		//		List<String>imgpath=new ArrayList<>();
		//		//buyListの数だけ繰り返す拡張for文
		//		for(Item buy:buyList) {
		//			//すべてのtextbookからIdが一致するものを検索し、結果のタイトルをストリングのリストに入れる
		//			for(Textbook text:textbookList) {
		//				if(text.getId()==buy.getTextbookId()) {
		//					textname.add(text.getTitle());
		//				}
		//			}
		//			//すべてのItemImageからIdが一致するものを検索し、結果のimgpathをストリングのリストに入れる
		//			for(ItemImage img:imgList) {
		//				if(img.getItemId()==buy.getId()) {
		//					imgpath.add(img.getImagePath());
		//				}
		//			}
		//		}
		//		model.addAttribute("textnameList",textname);
		//		model.addAttribute("imgpathList",imgpath);

		model.addAttribute("textbookList", textbookList);
		model.addAttribute("imgList", imgList);
		model.addAttribute("imgList2", imgList2);
		model.addAttribute("buyList", buyList);
		model.addAttribute("sellList", sellList);
		model.addAttribute("countsellList",countsellList);
		model.addAttribute("countbuyList",countbuyList);
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
		//検索したユーザーの学籍番号を送信
		model.addAttribute("studentNumber", user.getStudentNumber());
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
