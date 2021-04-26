package com.koreait.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class BoardWirteServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		if(no != null) {
			request.setAttribute("data", Database.list.get(Integer.parseInt(no)-1));
		}
		
		String jsp = "WEB-INF/jsp/write.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(jsp);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		if(no != "") {
			Database.list.remove(Integer.parseInt(no)-1);
		}
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		//브라우저에서 넘어오면 getparameter
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		Database.list.add(vo);
		
		response.sendRedirect("/list"); //get방식으로 주소이동 !
	}

}
