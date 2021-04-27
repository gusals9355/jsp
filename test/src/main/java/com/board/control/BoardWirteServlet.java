package com.board.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardBean;
import com.board.model.Database;

@WebServlet("/write")
public class BoardWirteServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		String jsp = "WEB-INF/jsp/write.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(jsp);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//브라우저에서 넘어오면 getparameter
		BoardBean bean = new BoardBean();
		bean.setTitle(title);
		bean.setContent(content);
		Database ds = new Database();
		ds.insertBoard(bean);
		
		response.sendRedirect("/list"); //get방식으로 주소이동 !
	}

}
