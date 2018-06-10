package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.Service;
import com.edu.vo.Buyer;
import com.edu.vo.Seller;

public class BuyerJoinController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if (id.isEmpty() || password.isEmpty()) {
			request.setAttribute("error", ERROR_EMPTY_SET);
			HttpUtil.forward(request, response, "/buyer/buyerJoin.jsp");
			return;
		}
		
		Service service = Service.getInstanse();
		String dbPassword = service.buyerLogin(id);
		if (dbPassword != null) {
				request.setAttribute("error", ERROR_USING_ID);
				HttpUtil.forward(request, response, "/buyer/buyerJoin.jsp");
				return;
			} else {
				Buyer b = new Buyer(id, password);
				service.buyerJoin(b);
				request.setAttribute("error", id+" 님 회원가입이 완료되었습니다.");
				HttpUtil.forward(request, response, "/buyer/buyerLogin.jsp");
			}
		}
		
	}