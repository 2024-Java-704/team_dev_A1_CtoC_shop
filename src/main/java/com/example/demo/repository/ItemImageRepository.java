package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ItemImage;

public interface ItemImageRepository extends JpaRepository<ItemImage, Integer> {

	ItemImage findByItemId(Integer id);	//該当の商品IDの画像をすべて取得

	ItemImage findDistinctByItemId(Integer itemId);

}
