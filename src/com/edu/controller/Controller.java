package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public final String ERROR_EMPTY_SET = "모든 항목을 입력하십시오.<br>";
	public final String ERROR_WRONG_PASSWORD = "비밀번호가 다릅니다.<br>";
	public final String ERROR_USING_ID = "이미 사용중인 아이디 입니다.<br>";
	public final String ERROR_NO_ID = "존재하지 않는 아이디 입니다.<br>";
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
