package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		List<Textbook> bookList =null;
		List<ItemImage> itemImage = null;
		List<Textbook> textbook = null;
		ArrayList<Integer>textIdList=new ArrayList<>();
		if(keyword.length()==0 ||keyword.equals(null)) {
			itemList=itemRepository.findDistinctByTextbookIdOrderByAsc();
			for(Item itemlist :itemList ) {
				itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
		//	textbook.add(textbookRepository.findById(itemlist.getTextbookId()));
			}
		}else {
			bookList=textbookRepository.findByTitleLike(keyword);
			/*	for( itemlist :itemList ) {
			 }
			 */
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("itemList", itemList);
		return "home";
	}
}