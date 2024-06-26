package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.History;
import com.example.demo.entity.ImageData;
import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Notice;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.ImageDataRepository;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TextbookRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemImageRepository itemImageRepository;

	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	NoticeRepository noticeRepository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	HistoryRepository historyRepository;

	@Autowired
	ImageDataRepository imageDataRepository;

	@Autowired
	Account account;

	@GetMapping("/home")
	public String textList(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Item> items = null;
		List<Item> itemList = new ArrayList<>();
		List<Textbook> bookList = null;
		List<ItemImage> itemImages = new ArrayList<>();
		List<ImageData> imageDatas = new ArrayList<>();
		List<Textbook> textbooks = new ArrayList<>();

		//キーワード検索に何も入っていないとき
		if (keyword.length() == 0 || keyword.equals(null)) {
			//教科書の一覧を取得
			bookList = textbookRepository.findAll();
		} else {
			//キーワードを含む教科書の一覧を取得
			bookList = textbookRepository.findByTitleContainingOrderByIdAsc(keyword);
		}

		//教科書を一つずつ処理
		for (Textbook book : bookList) {
			items = itemRepository.findByTextbookIdAndDealStatusOrderByTextbookIdDesc(book.getId(), 3);
			if (items.size() > 0) {
				Item item = items.get(0);
				itemList.add(item);
			}
		}
		//itemを一つずつ処理
		for (Item item : itemList) {
			Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
			List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
			ItemImage itemImage = itemImageList.get(0);
			textbook.setTextimg(itemImage.getImagePath());
			textbook.setStyle(itemImage.getStyle());
			if (itemImage.getStyle() == 2) {
				ImageData imageData = imageDataRepository.findOneByItemImageId(itemImage.getId());
				imageDatas.add(imageData);
				textbook.setImage(imageData.getImageData());
			}
			textbooks.add(textbook);
		}

		model.addAttribute("keyword", keyword);
		model.addAttribute("itemImages", itemImages);
		model.addAttribute("imageDatas", imageDatas);
		model.addAttribute("textbooks", textbooks);
		return "home";
	}

	@GetMapping("/textbook/{id}")
	public String itemList(
			@PathVariable("id") Integer id,
			@RequestParam(name = "sort", defaultValue = "1") Integer sort,
			Model model) {
		List<Item> itemList = null;
		List<Textbook> textbooks = new ArrayList<>();
		List<ImageData> imageDatas = new ArrayList<>();
		//sortの値によって条件分岐
		if (sort == 1) {
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByIdDesc(id, 3);
			//itemList内のItemごとに処理
			for (Item item : itemList) {
				Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				ItemImage itemImage = itemImageList.get(0);
				item.setTextprice(textbook.getPrice());
				item.setTextimg(itemImage.getImagePath());
				item.setStyle(itemImage.getStyle());
				if (item.getStyle() == 2) {
					ImageData imageData = imageDataRepository.findOneByItemImageId(itemImage.getId());
					item.setImage(imageData.getImageData());
					imageDatas.add(imageData);
				}
				itemRepository.save(item);
				textbooks.add(textbook);
			}
		} else if (sort == 2) {
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByItemStatusDesc(id, 3);
			//itemList内のItemごとに処理
			for (Item item : itemList) {
				Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				ItemImage itemImage = itemImageList.get(0);
				item.setTextprice(textbook.getPrice());
				item.setTextimg(itemImage.getImagePath());
				item.setStyle(itemImage.getStyle());
				if (item.getStyle() == 2) {
					ImageData imageData = imageDataRepository.findOneByItemImageId(itemImage.getId());
					item.setImage(imageData.getImageData());
					imageDatas.add(imageData);
				}
				itemRepository.save(item);
				textbooks.add(textbook);
			}
		} else if (sort == 3) {
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByItemStatusAsc(id, 3);
			//itemList内のItemごとに処理
			for (Item item : itemList) {
				Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				ItemImage itemImage = itemImageList.get(0);
				item.setTextprice(textbook.getPrice());
				item.setTextimg(itemImage.getImagePath());
				item.setStyle(itemImage.getStyle());
				if (item.getStyle() == 2) {
					ImageData imageData = imageDataRepository.findOneByItemImageId(itemImage.getId());
					item.setImage(imageData.getImageData());
					imageDatas.add(imageData);
				}
				itemRepository.save(item);
				textbooks.add(textbook);
			}
		}
		//idを元に対応するTextbookを取得
		Textbook textbook = textbookRepository.findOneById(id);
		//sortの値によって条件に当てはまるitemListを取得
		switch (sort) {
		case 1:
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByIdDesc(id, 3);
			break;
		case 2:
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByItemStatusDesc(id, 3);
			break;
		case 3:
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByItemStatusAsc(id, 3);
		}
		model.addAttribute("imageDatas", imageDatas);
		model.addAttribute("textbook", textbook);
		model.addAttribute("sort", sort);
		model.addAttribute("itemList", itemList);
		return "textbook";
	}

	@GetMapping("/item/{id}")
	public String viewItem(
			@PathVariable("id") Integer id,
			Model model) {
		//ItemImageのリストを初期化
		List<ItemImage> itemImages = new ArrayList<>();
		//idに対応するItemオブジェクトを取得
		Item item = itemRepository.findById(id).get();
		//itemが持つtextbookIdから対応するTextbookオブジェクトを取得
		Textbook textbook = textbookRepository.findOneById(item.getTextbookId());
		//Textbookの価格をItemの価格としてセット
		item.setTextprice(textbook.getPrice());

		//itemのsellerIdから対応するUserオブジェクトを取得
		User user = userRepository.findById(item.getSellerId()).get();
		//Userが持つpersonalNumberに基づいてStudentオブジェクトを取得
		Student student = studentRepository.findOneByPersonalNumber(user.getPersonalNumber());

		//idに対応するItemImagesのリストを取得
		itemImages = itemImageRepository.findByItemId(id);
		List<ImageData> imageDatas = new ArrayList<>();
		for (ItemImage itemImage : itemImages) {
			if (itemImage.getStyle() == 2)
				imageDatas.add(imageDataRepository.findOneByItemImageId(itemImage.getId()));
		}

		model.addAttribute("textbook", textbook);
		model.addAttribute("student", student);
		model.addAttribute("item", item);
		model.addAttribute("itemImages", itemImages);
		model.addAttribute("imageDatas", imageDatas);

		return "item";
	}

	@GetMapping("/user/{id}")
	public String viewUser(
			@PathVariable("id") Integer id,
			Model model) {
		//パスパラメータのidを使ってユーザー情報を取得する
		User user = userRepository.findOneById(id);
		//教科書の一覧を取得する
		List<Textbook> textbooks = textbookRepository.findAll();
		//該当ユーザーが出品した商品のリストを取得する
		List<Item> itemList = itemRepository.findBySellerIdOrderByIdDesc(id);
		//取引が完了した商品のリストを作成する
		List<Item> sellItemList = new ArrayList<>();

		System.out.println();
		System.out.println(itemList.size());
		//itemListの各商品について
		for (Item item : itemList) {
			if (item.getDealStatus() > 2)
				sellItemList.add(item);
		}
		System.out.println(sellItemList.size());

		//商品画像のリストを作成する
		List<ItemImage> imageList = new ArrayList<>();
		//レビューのリストを作成する
		List<Review> reviewList = new ArrayList<>();
		List<ImageData> imageDatas = new ArrayList<>();

		if (sellItemList.size() > 0)
			//sellItemListの各商品について
			for (Item item : sellItemList) {
				//商品IDに紐づく商品画像のリストを取得する
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				//最初の商品画像を取得する
				ItemImage image = itemImageList.get(0);
				//imageListに追加する
				imageList.add(image);
				//商品IDに紐づくレビューを取得する
				Review review = reviewRepository.findOneByItemId(item.getId());
				//レビューが存在する場合
				if (review != null) {
					//reviewListに追加する
					reviewList.add(reviewRepository.findOneByItemId(item.getId()));
				}
			}

		if (imageList.size() > 0) {
			for (ItemImage itemImage : imageList) {
				if (itemImage.getStyle() == 2) {
					imageDatas.add(imageDataRepository.findOneByItemImageId(itemImage.getId()));
				}
			}
		}

		model.addAttribute("student", studentRepository.findOneByPersonalNumber(user.getPersonalNumber()));
		model.addAttribute("user", user);
		model.addAttribute("textbooks", textbooks);
		if (sellItemList.size() > 0)
			model.addAttribute("sellItemList", sellItemList);
		model.addAttribute("sellItemCount", sellItemList.size());
		if (imageList.size() > 0)
			model.addAttribute("imageList", imageList);
		model.addAttribute("imageCount", imageList.size());
		if (reviewList.size() > 0)
			model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewCount", reviewList.size());
		model.addAttribute("imageDatas", imageDatas);
		return "user";
	}

	@PostMapping("/buy/{id}")
	public String buy(@PathVariable("id") Integer id) {
		// パスパラメータからIDを取得し、そのIDに対応する商品を取得
		Item item = itemRepository.findById(id).get();
		// 商品の取引ステータスを4 (取引完了) に変更し、購入者のIDをセットして保存
		item.setDealStatus(4);
		item.setBuyerId(account.getId());
		itemRepository.save(item);

		// 購入履歴を取得
		History history = historyRepository.findOneByTextbookIdAndUserId(item.getTextbookId(), account.getId());

		// 購入履歴が存在する場合、ステータスを2に変更して保存
		if (history != null) {
			history.setStatus(2);
			historyRepository.save(history);
		} else {
			// 購入履歴が存在しない場合、新しく購入履歴を作成して保存
			history = new History(item.getTextbookId(), account.getId(), 1);
			historyRepository.save(history);
		}

		// 出品者に通知を送る
		Notice notice = new Notice(item.getSellerId(), "出品した商品が購入されました");
		noticeRepository.save(notice);

		// 取引詳細ページにリダイレクト
		return "redirect:/deal/{id}";
	}

	@GetMapping("/deal/{id}")
	public String deal(@PathVariable("id") Integer id,
			@ModelAttribute("msg") String errorMsg,
			Model model) {

		//ItemImageのリストを生成
		List<ItemImage> itemImage = new ArrayList<>();
		//idでItemを検索して取得
		Item item = itemRepository.findById(id).get();
		//ItemのtextbookIdでTextbookを検索して取得
		Textbook textbook = textbookRepository.findOneById(item.getTextbookId());
		//Itemの価格をTextbookの価格に設定
		item.setTextprice(textbook.getPrice());
		//ItemのsellerIdで出品者を検索して取得
		User userSeller = userRepository.findById(item.getSellerId()).get();
		//ItemのbuyerIdで購入者を検索して取得
		User userBuyer = userRepository.findById(item.getBuyerId()).get();
		//購入者の学籍番号でStudentを検索して取得
		Student student = studentRepository.findOneByPersonalNumber(userBuyer.getPersonalNumber());
		//idでItemImageを検索して取得し、リストに追加
		itemImage.addAll(itemImageRepository.findByItemId(id));
		//アカウントIDを取得
		Integer accountId = account.getId();

		//エラーチェック
		if (errorMsg.length() > 0) {
			model.addAttribute("errorMsg", errorMsg);
		}
		
		List<ImageData> imageDatas = new ArrayList<>();
		
		for (ItemImage image : itemImage) {
			if (image.getStyle() == 2) {
				imageDatas.add(imageDataRepository.findOneByItemImageId(image.getId()));
			}
		}

		model.addAttribute("item", item);
		model.addAttribute("textbook", textbook);
		model.addAttribute("accountId", accountId);
		model.addAttribute("userSeller", userSeller);
		model.addAttribute("student", student);
		model.addAttribute("itemImages", itemImage);
		model.addAttribute("imageDatas", imageDatas);
		
		return "deal";
	}

	//レビュー投稿
	@PostMapping("/review/{id}")
	public String review(@PathVariable("id") Integer id,
			@RequestParam(name = "message", defaultValue = "") String message,
			RedirectAttributes redirectAttributes) {
		
		//エラーチェック
		if (message == null || message.length() <= 0) {
			redirectAttributes.addFlashAttribute("msg", "レビューを入力してください");
			return "redirect:/deal/{id}";
		}

		Review review = new Review(id, message);
		Item item = itemRepository.findById(id).get();
		item.setDealStatus(5);
		reviewRepository.save(review);
		Notice notice = new Notice(item.getSellerId(), "出品した商品へのレビューが来ました！ 「" + message + "」");
		noticeRepository.save(notice);
		return "redirect:/complete";
	}

	@GetMapping("/complete")
	public String complete() {
		return "complete";
	}

	@GetMapping("/item/add")
	public String addItem(Model model) {

		Map<String, Integer> ItemStatusMap = new LinkedHashMap<>();
		ItemStatusMap.put("新品", 1);
		ItemStatusMap.put("中古", 2);
		ItemStatusMap.put("書き込みあり", 3);
		ItemStatusMap.put("破損あり", 4);

		List<Textbook> textbook = textbookRepository.findAll();
		Map<String, Integer> textbookMap = new LinkedHashMap<>();
		for (Textbook row : textbook) {
			Integer textbookid = row.getId();
			String textbookname = row.getTitle();
			textbookMap.put(textbookname, textbookid);
		}
		model.addAttribute("TextbookList", textbook);
		model.addAttribute("ItemStatusMap", ItemStatusMap);
		model.addAttribute("TextbookMap", textbookMap);
		return "addItem";
	}

	@PostMapping("/item/add")
	public String sendItem(@RequestParam(name = "images") MultipartFile[] images,
			@RequestParam(name = "textbookId") Integer textbookId,
			@RequestParam(name = "itemStatus") Integer itemStatus) throws IOException {
		Item item = new Item(textbookId, itemStatus, account.getId());
		itemRepository.save(item);
		
		for(MultipartFile image : images) {
			ItemImage itemImage = new ItemImage(item.getId(), 2);
			itemImageRepository.save(itemImage);
			ImageData imageData = new ImageData(itemImage.getId(), image.getBytes());
			imageDataRepository.save(imageData);
		}

//		for (MultipartFile image : images) {
//			ItemImage itemImage = new ItemImage(item.getId(), image.getOriginalFilename());
//			itemImageRepository.save(itemImage);
//			Path dst = Paths.get("src/main/resources/static/img/", image.getOriginalFilename());
//
//			System.out.println(image.getContentType());
//
//			if (Files.exists(dst)) {
//				System.out.println("同名ファイルがあります！");
//			}
//
//			Files.copy(image.getInputStream(), dst, StandardCopyOption.REPLACE_EXISTING);
//		}
		return "redirect:/home";
	}
}