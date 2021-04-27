package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

@WebServlet("/mod")
public class BoardUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		request.setAttribute("data", Database.list.get(Integer.parseInt(no))); 
		
		String jsp = "WEB-INF/jsp/mod.jsp";
		RequestDispatcher dis = request. getRequestDispatcher(jsp);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String no = request.getParameter("no");
		
		BoardVO vo = Database.list.get(Integer.parseInt(no));
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		response.sendRedirect("/detail?no="+no);
	}

}