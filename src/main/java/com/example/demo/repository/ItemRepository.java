package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{


	List<Item> findBySellerIdOrderByIdDesc(Integer sellerId);
	
	List<Item> findByBuyerIdOrderByIdDesc(Integer buyerId);

	Item findOneById(Integer id);

	List<Item> findDistinctByTextbookIdOrderByIdAsc(Integer textbookId);
	
	List<Item> findByTextbookIdOrderByIdDesc(Integer textbookId);

	List<Item> findByTextbookIdOrderByItemStatusDesc(Integer textbookId);

	List<Item> findByTextbookIdOrderByItemStatusAsc(Integer textbookId);

	List<Item> findByDealStatus(Integer dealStatus);

}
