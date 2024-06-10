package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{


	List<Item>findBySellerIdOrderByIdDesc(Integer id);
	List<Item>findByBuyerIdOrderByIdDesc(Integer id);
	


	Item findOneById(Integer id);

	List<Item> findDistinctByTextbookIdOrderByIdAsc();

	List<Item> findDistinctByTextbookIdOrderByIdAsc(Integer id);

	List<Item> findByTextbookIdOrderByIdDesc(Integer textBookid);

	List<Item> findByTextbookIdOrderByitemStatusDesc(Integer id);

	List<Item> findByTextbookIdOrderByitemStatusAsc(Integer id);

	List<Item> findByDealStatus(int dealStatus);

}
