package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ImageData;

public interface ImageDataRepository extends JpaRepository<ImageData, Integer> {

	List<ImageData> findByItemImageId(Integer itemImageId);//該当の商品IDの画像をすべて取得
	
	ImageData findOneByItemImageId(Integer itemImageId);

}