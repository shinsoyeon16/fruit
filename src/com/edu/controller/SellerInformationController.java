package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.service.Service;
import com.edu.vo.Seller;

public class SellerInformationController  implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Service service = Service.getInstanse();
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("sellerId");
		
		Seller s = service.sellerInformation(id);
		
		request.setAttribute("seller", s);
		HttpUtil.forward(request, response, "/seller/sellerInformation.jsp");
	}
}
