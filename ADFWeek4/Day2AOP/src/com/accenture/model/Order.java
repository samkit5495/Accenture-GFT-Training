package com.accenture.model;

public class Order {
	private int id;
	private String itemName;
	private int price;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String itemName, int price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getItemName() {
		return itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}
//	
}
