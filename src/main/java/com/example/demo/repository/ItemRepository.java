package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findBySellerIdOrderByIdDesc(Integer id);

	List<Item> findByBuyerIdOrderByIdDesc(Integer id);

	Item findOneById(Integer id);

	List<Item> findByTextbookIdOrderByItemStatusDesc(Integer textbookId);

	List<Item> findByTextbookIdOrderByItemStatusAsc(Integer textbookId);

	List<Item> findDistinctByTextbookIdOrderByIdAsc();

	List<Item> findByTextbookIdOrderByitemStatusDesc(Integer id);

	List<Item> findByTextbookIdOrderByitemStatusAsc(Integer id);

	List<Item> findByDealStatus(int dealStatus);

	List<Item> findAllByOrderByTextbookIdDesc();

	List<Item> findByDealStatus(Integer dealStatus);
}