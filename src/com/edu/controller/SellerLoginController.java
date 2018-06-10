package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.service.Service;

public class SellerLoginController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		Service service = Service.getInstanse();
		String dbPassword = service.sellerLogin(id);
		if (id.isEmpty() || password.isEmpty()) {
			request.setAttribute("error", ERROR_EMPTY_SET);
			HttpUtil.forward(request, response, "/seller/sellerLogin.jsp");
			return;
		}
		if (dbPassword == null) {
			request.setAttribute("error", ERROR_NO_ID);
			HttpUtil.forward(request, response, "/seller/sellerLogin.jsp");
			return;
		} else {
			if (!dbPassword.equals(password)) {
				request.setAttribute("error", ERROR_WRONG_PASSWORD);
			} else if (dbPassword.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("sellerId", id);
				HttpUtil.forward(request, response, "/seller/sellerMenu.jsp");
				return;
			}

			HttpUtil.forward(request, response, "/seller/sellerLogin.jsp");
		}

	}
}