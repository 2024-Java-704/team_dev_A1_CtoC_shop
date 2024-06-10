package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Review {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id; //レビューID

@Column(name="item_id")
private Integer itemId; //商品ID

private String message;

//コンストラクタ
public Review(){
}

public Review(Integer itemId,String message){
	this.itemId=itemId;
	this.message=message;
}

 //メソッド
public Integer getId() {
	return id;
}

public Integer getItemId() {
	return itemId;
}

public String getMessage() {
	return message;
}

}
