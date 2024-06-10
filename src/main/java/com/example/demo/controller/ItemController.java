package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Textbook;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.TextbookRepository;

@Controller
public class ItemController {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemImageRepository itemImageRepository;

	@Autowired
	TextbookRepository textbookRepository;

	@Autowired
	Account account;

	@GetMapping("/home")
	public String textList(
			@RequestParam(name = "keyword", defaultValue = "") String keyword,
			Model model) {
		List<Item> itemList = null;
		List<Textbook> bookList = null;
		List<ItemImage> itemImage = new ArrayList<>();
		List<Textbook> textbook = new ArrayList<>();
		if (keyword.length() == 0 || keyword.equals(null)) {
			itemList = itemRepository.findDistinctByTextbookIdOrderByAsc();
			for (Item itemlist : itemList) {
				itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
				textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
			}
		} else {
			bookList = textbookRepository.findByTitleLikeOrderByAsc(keyword);
			for (Textbook booklist : bookList) {
				itemList = itemRepository.findDistinctByTextbookIdOrderByAsc(booklist.getId());
				for (Item itemlist : itemList) {
					itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
					textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
				}
			}
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("itemList", itemList);
		model.addAttribute("itemImage", itemImage);
		model.addAttribute("textbook", textbook);
		return "home";
	}

	//	@GetMapping("/textbook/{id}")
	//	public String itemList(
	//						   @PathVariable("id")Integer id,
	//						   @RequestParam(name="sort", defaultValue="1")Integer sort,
	//						   Model model){
	//		List<Item> itemList = null;
	//		//List<Textbook> bookList =null;
	//		List<ItemImage> itemImage=new ArrayList<>();
	//		List<Textbook> textbook=new ArrayList<>();
	//		if(sort==1) {
	//			itemList=itemRepository.findByTextbookIdOrderByDesc(id);
	//			for(Item itemlist :itemList ) {
	//				itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
	//				textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
	//			}
	//				}else if(sort==2) {
	//					itemList=itemRepository.findByTextbookIdOrderByitemStatusDesc(id);
	//					for(Item itemlist :itemList ) {
	//					itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
	//					textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
	//			}
	//				}else if(sort==3) {
	//					itemList=itemRepository.findByTextbookIdOrderByitemStatusAsc(id);
	//					for(Item itemlist :itemList ) {
	//					itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
	//					textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
	//			}
	//				}
	//					model.addAttribute("itemList", itemList);
	//					model.addAttribute("itemImage", itemImage);
	//					model.addAttribute("textbook",textbook);
	//			return "textbook";
	//	}
	@GetMapping("/item/{id}")
	public String viewItem(
			@PathVariable("id") Integer id,
			Model model) {
		Item item = null;
		List<ItemImage> itemImage = new ArrayList<>();
		item = itemRepository.findById(id).get();
		itemImage.add(itemImageRepository.findByItemId(item.getId()));
		return "item";
	}

	@GetMapping("/user/{id}")
	public String viewUser(
			@PathVariable("id") Integer id,
			Model model) {
		List<Item> itemList = null;
		List<Textbook> bookList = null;
		//	itemList=itemRepository.findBySellerId(id);
		return "";
	}
}