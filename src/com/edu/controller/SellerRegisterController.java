package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.service.Service;
import com.edu.vo.Seller;

public class SellerRegisterController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String count = request.getParameter("count");
		String price = request.getParameter("price");

		if (count.isEmpty() || price.isEmpty()) {
			request.setAttribute("error", ERROR_EMPTY_SET);
			HttpUtil.forward(request, response, "/seller/sellerRegister.jsp");
			return;
		}

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sellerId");
		Service service = Service.getInstanse();
		service.sellerRegister(Integer.parseInt(count), Integer.parseInt(price), id);
		Seller s = service.sellerInformation(id);
		
		request.setAttribute("seller", s);
		HttpUtil.forward(request, response, "/seller/sellerInformation.jsp");
	}
}
