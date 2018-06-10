package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.service.Service;
import com.edu.vo.Buyer;

public class BuyerInformationController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Service service = Service.getInstanse();
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("buyerId");

		Buyer b = service.buyerInformation(id);

		request.setAttribute("buyer", b);
		HttpUtil.forward(request, response, "/buyer/buyerInformation.jsp");
	}
}
