package com.edu.vo;

public class Buyer {
	private String id;
	private String password;
	private int money;
	private int appleCount;
	
	public Buyer() {}
	public Buyer(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public Buyer(String id, String password, int money, int appleCount) {
		this.id = id;
		this.password = password;
		this.money = money;
		this.appleCount = appleCount;
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
	
	public void buyFruit(Seller s, int money) {
		int count = s.salesFruit(money);
		this.appleCount += count;
		this.money -= money;
	}
}
