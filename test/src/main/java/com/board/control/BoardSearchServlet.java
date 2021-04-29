package com.board.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.Database;

@WebServlet("/BoardSearchServlet")
public class BoardSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database ds = new Database();
		String search = request.getParameter("search");
		
		request.setAttribute("title", ds.getTitle(search));
		request.setAttribute("search", ds.selectSearch(search)); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
