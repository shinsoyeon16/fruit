package com.edu.vo;

public class Seller {
	private String id;
	private String password;
	private int money;
	private int appleCount;
	private int applePrice;
	
	public Seller() {}
	public Seller(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public Seller(String id, String password, int money, int appleCount, int applePrice) {
		this.id = id;
		this.password = password;
		this.money = money;
		this.appleCount = appleCount;
		this.applePrice = applePrice;
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money=money;
	}
	public int getAppleCount() {
		return appleCount;
	}
	public void setAppleCount(int appleCount) {
		this.appleCount=appleCount;
	}
	public int getApplePrice() {
		return applePrice;
	}
	public void setApplePrice(int applePrice) {
		this.applePrice=applePrice;
	}

	public int salesFruit(int money) {
		int count=money/this.applePrice;
		this.appleCount -= count;
		this.money += money;
		return count;
	}

}
