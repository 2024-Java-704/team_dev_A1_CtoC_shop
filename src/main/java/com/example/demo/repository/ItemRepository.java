package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{
	List<Item>findBySellerIdOrderByIdDesc(Integer id);
	List<Item>findByBuyerIdOrderByIdDesc(Integer id);
	
}
