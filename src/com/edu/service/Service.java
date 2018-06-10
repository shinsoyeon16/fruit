package com.edu.service;

import java.util.ArrayList;

import com.edu.dao.Dao;
import com.edu.vo.Buyer;
import com.edu.vo.Seller;

public class Service {
	private static Service service = new Service();
	private Dao dao = Dao.getInstance();

	private Service() {
	}

	public static Service getInstanse() {
		return service;
	}

	public String sellerLogin(String id) {
		return dao.sellerLogin(id);
	}

	public String buyerLogin(String id) {
		return dao.buyerLogin(id);
	}

	public void sellerJoin(Seller s) {
		dao.sellerJoin(s);
	}

	public void buyerJoin(Buyer b) {
		dao.buyerJoin(b);
	}

	public void sellerRegister(int count, int price, String id) {
		dao.sellerRegister(count, price, id);
	}

	public void buyerRegister(int money, String id) {
		dao.buyerRegister(money, id);
	}

	public Seller sellerInformation(String id) {
		return dao.sellerInformation(id);
	}

	public Buyer buyerInformation(String id) {
		return dao.buyerInformation(id);
	}

	public ArrayList<Seller> sellerList() {
		return dao.sellerList();
	}

	public void buyerBuyFruit(Buyer b) {
		dao.buyerBuyFruit(b);
	}

	public void sellerSalesFruit(Seller s) {
		dao.sellerSalesFruit(s);
	}

}
