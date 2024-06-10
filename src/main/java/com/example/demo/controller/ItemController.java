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

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemImage;
import com.example.demo.entity.Review;
import com.example.demo.entity.Textbook;
import com.example.demo.entity.User;
import com.example.demo.model.Account;
import com.example.demo.repository.ItemImageRepository;
import com.example.demo.repository.ItemRepository;
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
	Account account;

	@GetMapping("/home")
	public String textList(
						   @RequestParam(name = "keyword", defaultValue = "") String keyword,
						   Model model) {
		List<Item> items = null;
		List<Item> itemList =  new ArrayList<>();
		List<Textbook> bookList =null;
		List<ItemImage> itemImage=new ArrayList<>();
		List<Textbook> textbook=new ArrayList<>();
		if(keyword.length()==0 ||keyword.equals(null)) {
			items=itemRepository.findAllByOrderByTextbookIdDesc();
			Item item = items.get(0);
			for(int i=0;i<=item.getTextbookId();i++) {
				itemList.addAll(itemRepository.findDistinctByTextbookIdOrderByIdAsc(i));
			}
			for(Item itemlist :itemList ) {
				itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
				textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
			}
		}else {
			bookList=textbookRepository.findByTitleLikeOrderByIdAsc(keyword);
				for(Textbook booklist :bookList ) {
					itemList=itemRepository.findDistinctByTextbookIdOrderByIdAsc(booklist.getId());
					for(Item itemlist :itemList ) {
						itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
						textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
					}
				}
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("itemList", itemList);
		model.addAttribute("itemImage", itemImage);
		model.addAttribute("textbook",textbook);
		return "home";
	}
	
	@GetMapping("/textbook/{id}")
	public String itemList(
						   @PathVariable("id")Integer id,
						   @RequestParam(name="sort", defaultValue="1")Integer sort,
						   Model model){
		List<Item> itemList = null;
		//List<Textbook> bookList =null;
		List<ItemImage> itemImage=new ArrayList<>();
		List<Textbook> textbook=new ArrayList<>();
		if(sort==1) {
			itemList=itemRepository.findByTextbookIdOrderByIdDesc(id);
			for(Item itemlist :itemList ) {
				itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
				textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
			}
				}else if(sort==2) {
					itemList=itemRepository.findByTextbookIdOrderByItemStatusDesc(id);
					for(Item itemlist :itemList ) {
					itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
					textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
			}
				}else if(sort==3) {
					itemList=itemRepository.findByTextbookIdOrderByItemStatusAsc(id);
					for(Item itemlist :itemList ) {
					itemImage.add(itemImageRepository.findDistinctByItemId(itemlist.getId()));
					textbook.add(textbookRepository.findById(itemlist.getTextbookId()).get());
			}
				}
					model.addAttribute("itemList", itemList);
					model.addAttribute("itemImage", itemImage);
					model.addAttribute("textbook",textbook);
			return "textbook";
	}
	@GetMapping("/item/{id}")
	public String viewItem(
						   @PathVariable("id")Integer id,
						   Model model) {
		Item item = null;
		List<ItemImage> itemImage=new ArrayList<>();
			item=itemRepository.findById(id).get();
			itemImage.add(itemImageRepository.findByItemId(item.getId()));
			model.addAttribute("item", item);
			model.addAttribute("itemImage",itemImage);
			return "item";
	}
	@GetMapping("/user/{id}")
	public String viewUser(
						   @PathVariable("id")Integer id,
						   Model model) {
		User user = null;
		Item item=itemRepository.findById(id).get();
			user=userRepository.findById(item.getSellerId()).get();
			model.addAttribute("item", item);
			model.addAttribute("user",user);
		return"user";
	}
	@PostMapping("/buy/{id}")
	public String buy(@PathVariable("id")Integer id,
					  Model model) {
		Item item= itemRepository.findById(id).get();
		item.setDealStatus(4);
		item.setBuyerId(account.getId());
		itemRepository.save(item);

		return"redirect:/deal/{id}";
	}
	@GetMapping("/deal/{id}")
	public String deal(@PathVariable("id") Integer id,
					   Model model) {
		List<ItemImage>itemImage=new ArrayList<>();
		Item item= itemRepository.findById(id).get();
		User user= userRepository.findById(item.getSellerId()).get();
		itemImage.add(itemImageRepository.findByItemId(id));
		
		model.addAttribute("item", item);
		model.addAttribute("user",user);
		model.addAttribute("itemImage", itemImage);
		
		return "deal";
	}
	@PostMapping("/review/{id}")
	public String review(@PathVariable("id")Integer id,
						 @RequestParam(name="message",defaultValue="")String message) {
		Review review = new Review(id,message);
		Item item =itemRepository.findById(id).get();
		item.setDealStatus(5);
		reviewRepository.save(review);
		return "redirect:/complete";
	}
	@GetMapping("/complete")
		public String complete(){
		return "complete";
	}
	@GetMapping("/item/add")
		public String addItem() {
		return "addItem";
	}
	@PostMapping("/item/add")
		public String sendItem(@RequestParam(name="Images") String[] image,
							   @RequestParam(name="textbookId")Integer textbookId,
							   @RequestParam(name="itemStatus")Integer itemStatus) {
		return "";
	}
}