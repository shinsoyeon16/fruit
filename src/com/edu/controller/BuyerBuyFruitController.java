package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.service.Service;
import com.edu.vo.Buyer;
import com.edu.vo.Seller;

public class BuyerBuyFruitController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Service service = Service.getInstanse();

		String sellerId = request.getParameter("sellerId");
		String count = request.getParameter("count");

		if (sellerId.isEmpty() || count.isEmpty()) {
			request.setAttribute("error", ERROR_EMPTY_SET);
			HttpUtil.forward(request, response, "buyer/buyerBuyFruit.jsp");
		}

		if (service.sellerLogin(sellerId) == null) {
			request.setAttribute("error", "정확한 판매자 정보를 입력하세요.");
			HttpUtil.forward(request, response, "buyer/buyerBuyFruit.jsp");
		}
		Seller s = service.sellerInformation(sellerId);
		s.setId(sellerId);

		if (!(s.getAppleCount() >= Integer.parseInt(count))) {
			request.setAttribute("error", "정확한 구매정보를 입력하세요.");
			HttpUtil.forward(request, response, "buyer/buyerBuyFruit.jsp");
			return;
		}
		HttpSession session = request.getSession(false);
		String buyerId = (String) session.getAttribute("buyerId");

		Buyer b = service.buyerInformation(buyerId);

		int money = Integer.parseInt(count) * s.getApplePrice();
		if (b.getMoney() < money) {
			request.setAttribute("error", "정확한 구매정보를 입력하세요.");
			HttpUtil.forward(request, response, "buyer/buyerBuyFruit.jsp");
			return;
		}
		b.buyFruit(s, money);
		service.buyerBuyFruit(b);
		service.sellerSalesFruit(s);
		b = service.buyerInformation(b.getId());
		request.setAttribute("buyer", b);
		HttpUtil.forward(request, response, "buyer/buyerInformation.jsp");
	}
}
