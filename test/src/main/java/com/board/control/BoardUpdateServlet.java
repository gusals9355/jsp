package com.board.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.board.model.Database;

@WebServlet("/mod")
public class BoardUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		Database ds = new Database();
		request.setAttribute("data", ds.getOneBoard(Integer.parseInt(no))); 
		
		String jsp = "WEB-INF/jsp/mod.jsp";
		RequestDispatcher dis = request. getRequestDispatcher(jsp);
		dis.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Database ds = new Database();
		ds.updateBoard(title, content, Integer.parseInt(no));
		
		response.sendRedirect("/detail?no="+no);
	}

}