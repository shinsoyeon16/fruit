package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.service.Service;
import com.edu.vo.Buyer;
import com.edu.vo.Seller;
public class BuyerRegisterController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String money = request.getParameter("money");

		if (money.isEmpty()) {
			request.setAttribute("error", ERROR_EMPTY_SET);
			HttpUtil.forward(request, response, "/buyer/buyerRegister.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("buyerId");
		Service service = Service.getInstanse();
		
		service.buyerRegister(Integer.parseInt(money), id);
		Buyer b= service.buyerInformation(id);
		
		request.setAttribute("buyer", b);
		HttpUtil.forward(request, response, "/buyer/buyerInformation.jsp");
		}
}

