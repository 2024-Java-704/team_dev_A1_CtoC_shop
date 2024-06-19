package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findBySellerIdOrderByIdDesc(Integer id);

	List<Item> findByBuyerIdOrderByIdDesc(Integer id);

	Item findOneById(Integer id);	//該当のIDの商品の情報を取得

	List<Item> findOneByTextbookIdAndDealStatusOrderByIdAsc(Integer textbookId, Integer dealStatus);

	List<Item> findByTextbookIdAndDealStatusOrderByIdDesc(Integer textbookId, Integer dealStatus);

	List<Item> findByTextbookIdAndDealStatusOrderByItemStatusDesc(Integer textbookId, Integer dealStatus);

	List<Item> findByTextbookIdAndDealStatusOrderByItemStatusAsc(Integer textbookId, Integer dealStatus);

	List<Item> findAllByOrderByTextbookIdDesc();

	List<Item> findByDealStatus(Integer dealStatus); //特定の取引状態の商品をすべて取得

	List<Item> findByTextbookIdAndDealStatusOrderByTextbookIdDesc(Integer textbookId, Integer dealStatus);

	List<Item> findBySellerIdAndDealStatus(Integer sellerId, Integer dealStatus);

}
