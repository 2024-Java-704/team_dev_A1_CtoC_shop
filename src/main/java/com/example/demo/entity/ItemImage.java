package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="item_images")
public class ItemImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="item_id")
	private Integer itemId;
	
	@Column(name="image_path")
	private String imagePath;

	//コンストラクタ
	public ItemImage(){
	}
	
	public ItemImage(Integer itemId,String imagePath) {
		this.itemId=itemId;
		this.imagePath=imagePath;
	}
//メソッド
	public Integer getId() {
		return id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	
	
}
