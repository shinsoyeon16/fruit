package com.edu.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		list.put("/sellerLogin.do", new SellerLoginController());
		list.put("/buyerLogin.do", new BuyerLoginController());
		list.put("/sellerJoin.do", new SellerJoinController());
		list.put("/buyerJoin.do", new BuyerJoinController());
		list.put("/sellerRegister.do", new SellerRegisterController());
		list.put("/buyerRegister.do", new BuyerRegisterController());
		list.put("/sellerInformation.do", new SellerInformationController());
		list.put("/buyerInformation.do", new BuyerInformationController());
		list.put("/buyerBuyFruit.do", new BuyerBuyFruitController());
		list.put("/logout.do", new LogoutController()); //seller&buyer 공통 기능
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}

}