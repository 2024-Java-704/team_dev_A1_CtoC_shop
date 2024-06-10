package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{


	List<Item> findBySellerIdOrderByIdDesc(Integer id);
	List<Item> findByBuyerIdOrderByIdDesc(Integer id);

	
	
	Item findOneById(Integer id);

	
	
	List<Item> findDistinctByTextbookIdOrderByIdAsc(Integer id);
	
	List<Item> findByTextbookIdOrderByIdDesc(Integer textbookId);

	List<Item> findByTextbookIdOrderByItemStatusDesc(Integer textbookId);

	List<Item> findByTextbookIdOrderByItemStatusAsc(Integer textbookId);

	
	List<Item> findAllByOrderByTextbookIdDesc();
	
	
	
	
	List<Item> findByDealStatus(Integer dealStatus);

}
