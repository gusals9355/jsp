package com.koreait.board6.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("회원가입", "user/userJoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		String gender = request.getParameter("gender");
		
		System.out.println(uid);
		System.out.println(upw);
		System.out.println(unm);
		
		int result = 0;
		
		PrintWriter pw = response.getWriter();
		pw.append(String.format("{\"result\": %d}", result));
		//json 멤버필드 "" 값이 문자열이면 ""
	}

}
