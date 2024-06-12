package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.ItemImageRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //商品ID

	@Column(name = "textbook_id")
	private Integer textbookId; //教科書ID

	@Column(name = "item_status")
	private Integer itemStatus; //商品状態　1＝新品、２＝中古、3＝書き込みあり、4＝破損あり

	@Column(name = "deal_status")
	private Integer dealStatus; //取引状態　1＝審査待ち、2＝不許可、3＝出品中（許可）、4＝取引中、5＝完了

	@Column(name = "seller_id")
	private Integer sellerId; //出品者ID

	@Column(name = "buyer_id")
	private Integer buyerId; //購入者ID

	@Transient
	private Integer textprice;

	@Transient
	private String textimg;

	@Transient
	@Autowired
	ItemImageRepository itemImageRepository;

	//コンストラクタ
	public Item() { //デフォルトコンストラクタ	
	}

	public Item(Integer textbookId, Integer itemStatus, Integer sellerId) {
		this.textbookId = textbookId;
		this.itemStatus = itemStatus;
		this.sellerId = sellerId;
		this.dealStatus = 1;
	}

	//メソッド
	public Integer getId() {
		return id;
	}

	public Integer getTextbookId() {
		return textbookId;
	}

	public Integer getItemStatus() {
		return itemStatus;
	}

	public Integer getDealStatus() {
		return dealStatus;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setDealStatus(Integer dealStatus) {
		this.dealStatus = dealStatus;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getTextprice() {
		return textprice;
	}

	public void setTextprice(Integer textprice) {
		this.textprice = textprice;
	}

	public String getTextimg() {
		return textimg;
	}

	public void setTextimg(String textimg) {
		this.textimg = textimg;
	}
	
	@Transient
	public String getItemImagePath() {
		ItemImage itemImage = itemImageRepository.findOneByItemId(id);
		return itemImage.getImagePath();
	}

}
