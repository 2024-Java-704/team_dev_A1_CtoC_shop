package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemImage;

public interface ItemImageRepository extends JpaRepository<ItemImage, Integer> {

	List<ItemImage> findByItemId(Integer id);//該当の商品IDの画像をすべて取得
	
	ItemImage findDistinctByItemId(Integer itemId);

	ItemImage findOneByItemId(Integer itemId);

}
