package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//브라우저 에서 서버쪽으로 넘어오면 requset.getParameter(키값);
		//서블릿에서 jsp로 값 전달하는 방법 (빼는 방법) requset.getAttribute (키값);
		//서블릿에서 jsp로 값 전달하는 방법 (넣는 방법) requset.setAttribute (키값,value);
		request.setAttribute("data", Database.list); 
		
		String jsp = "WEB-INF/jsp/list.jsp";
		RequestDispatcher dis = request. getRequestDispatcher(jsp);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
