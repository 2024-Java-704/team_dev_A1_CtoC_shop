package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Review;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.repository.ReviewRepository;
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
	Account account;

	@GetMapping("/home")
	public String textList(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Item> items = null;
		List<Item> itemList = new ArrayList<>();
		List<Textbook> bookList = null;
		List<ItemImage> itemImages = new ArrayList<>();
		List<Textbook> textbooks = new ArrayList<>();
		if (keyword.length() == 0 || keyword.equals(null)) {
			items = itemRepository.findAllByOrderByTextbookIdDesc();
			Item item = items.get(0);
			for (int i = 0; i <= item.getTextbookId(); i++) {
				itemList.addAll(itemRepository.findOneByTextbookIdAndDealStatusOrderByIdAsc(i + 1, 3));
			}
			for (Item i : itemList) {
				Textbook textbook = textbookRepository.findById(i.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(i.getId());
				ItemImage itemImage = itemImageList.get(0);
				textbook.setTextimg(itemImage.getImagePath());
				textbooks.add(textbook);
			}
		} else {
			bookList = textbookRepository.findByTitleLikeOrderByIdAsc(keyword);
			for (Textbook book : bookList) {
				itemList = itemRepository.findOneByTextbookIdAndDealStatusOrderByIdAsc(book.getId(), 3);
				for (Item it : itemList) {
					Textbook textbook = textbookRepository.findById(it.getTextbookId()).get();
					List<ItemImage> itemImageList = itemImageRepository.findByItemId(it.getId());
					ItemImage itemImage = itemImageList.get(0);
					textbook.setTextimg(itemImage.getImagePath());
					textbooks.add(textbook);
				}
			}
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("itemImages", itemImages);
		model.addAttribute("textbooks", textbooks);
		return "home";
	}

	@GetMapping("/textbook/{id}")
	public String itemList(
			@PathVariable("id") Integer id,
			@RequestParam(name = "sort", defaultValue = "1") Integer sort,
			Model model) {
		List<Item> itemList = null;
		//List<Textbook> bookList =null;
		//List<ItemImage> itemImages = new ArrayList<>();
		List<Textbook> textbooks = new ArrayList<>();
		if (sort == 1) {
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByIdDesc(id, 3);
			for (Item item : itemList) {
				Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				ItemImage itemImage = itemImageList.get(0);
				item.setTextprice(textbook.getPrice());
				item.setTextimg(itemImage.getImagePath());
				itemRepository.save(item);
				textbooks.add(textbook);
			}
		} else if (sort == 2) {
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByItemStatusDesc(id, 3);
			for (Item item : itemList) {
				Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				ItemImage itemImage = itemImageList.get(0);
				item.setTextprice(textbook.getPrice());
				item.setTextimg(itemImage.getImagePath());
				itemRepository.save(item);
				textbooks.add(textbook);
			}
		} else if (sort == 3) {
			itemList = itemRepository.findByTextbookIdAndDealStatusOrderByItemStatusAsc(id, 3);
			for (Item item : itemList) {
				Textbook textbook = textbookRepository.findById(item.getTextbookId()).get();
				List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
				ItemImage itemImage = itemImageList.get(0);
				item.setTextprice(textbook.getPrice());
				item.setTextimg(itemImage.getImagePath());
				itemRepository.save(item);
				textbooks.add(textbook);
			}
		}
		Textbook textbook = textbookRepository.findOneById(id);
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
		model.addAttribute("textbook", textbook);
		model.addAttribute("sort", sort);
		model.addAttribute("itemList", itemList);
		//model.addAttribute("itemImage", itemImages);
		//model.addAttribute("textbook", textbooks);
		return "textbook";
	}

	@GetMapping("/item/{id}")
	public String viewItem(
			@PathVariable("id") Integer id,
			Model model) {
		List<ItemImage> itemImages = new ArrayList<>();
		Item item = itemRepository.findById(id).get();

		Textbook textbook = textbookRepository.findOneById(item.getTextbookId());
		item.setTextprice(textbook.getPrice());

		User user = userRepository.findById(item.getSellerId()).get();

		itemImages = itemImageRepository.findByItemId(id);
		model.addAttribute("textbook", textbook);
		model.addAttribute("user", user);
		model.addAttribute("item", item);
		model.addAttribute("itemImages", itemImages);
		return "item";
	}

	@GetMapping("/user/{id}")
	public String viewUser(
			@PathVariable("id") Integer id,
			Model model) {
		User user = userRepository.findOneById(id);
		List<Textbook> textbooks = textbookRepository.findAll();
		List<Item> sellItemList = itemRepository.findBySellerIdOrderByIdDesc(id);
		List<ItemImage> imageList = new ArrayList<>();
		List<Review> reviewList = new ArrayList<>();

		for (Item item : sellItemList) {
			List<ItemImage> itemImageList = itemImageRepository.findByItemId(item.getId());
			ItemImage image = itemImageList.get(0);
			imageList.add(image);
			reviewList.add(reviewRepository.findOneByItemId(item.getId()));
		}

		model.addAttribute("user", user);
		model.addAttribute("textbooks", textbooks);
		model.addAttribute("sellItemList", sellItemList);
		model.addAttribute("imageList", imageList);
		model.addAttribute("reviewList", reviewList);
		return "user";
	}

	@PostMapping("/buy/{id}")
	public String buy(@PathVariable("id") Integer id) {
		Item item = itemRepository.findById(id).get();
		item.setDealStatus(4);
		item.setBuyerId(account.getId());
		itemRepository.save(item);

		return "redirect:/deal/{id}";
	}

	@GetMapping("/deal/{id}")
	public String deal(@PathVariable("id") Integer id,
			Model model) {
		List<ItemImage> itemImage = new ArrayList<>();
		Item item = itemRepository.findById(id).get();
		User user = userRepository.findById(item.getSellerId()).get();
		itemImage.addAll(itemImageRepository.findByItemId(id));

		model.addAttribute("item", item);
		model.addAttribute("user", user);
		model.addAttribute("itemImage", itemImage);

		return "deal";
	}

	@PostMapping("/review/{id}")
	public String review(@PathVariable("id") Integer id,
			@RequestParam(name = "message", defaultValue = "") String message) {
		Review review = new Review(id, message);
		Item item = itemRepository.findById(id).get();
		item.setDealStatus(5);
		reviewRepository.save(review);
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
		for (MultipartFile image : images) {
			ItemImage itemImage = new ItemImage(item.getId(), image.getOriginalFilename());
			itemImageRepository.save(itemImage);
		}
		for (MultipartFile image : images) {
			Path dst = Paths.get("src/main/resources/static/img/", image.getOriginalFilename());
			Files.copy(image.getInputStream(), dst);
		}
		return "redirect:/home";
	}
}