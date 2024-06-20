package com.example.demo.entity;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_data")
public class ImageData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "item_image_id")
	private Integer itemImageId;

	@Column(name = "image")
	private byte[] image;

	public ImageData() {
	}
	
	public ImageData(Integer itemImageId, byte[] image) {
		this.itemImageId = itemImageId;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public Integer getItemImageId() {
		return itemImageId;
	}

	public String getImage() {
		return Base64.getEncoder().encodeToString(image);
	}

	public byte[] getImageData() {
		return image;
	}
	
}
