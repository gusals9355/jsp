package com.board.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.Database;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		Database ds = new Database();
		
		ds.readCountUp(Integer.parseInt(no));
		request.setAttribute("data", ds.getOneBoard(Integer.parseInt(no)));
		
		RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/jsp/detail.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
