package com.koreait.board6.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board6.MyUtils;
@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("detail", "board/boardDetail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		System.out.println(iboard);
		
		BoardVO result = BoardDAO.selBoard(Integer.parseInt(iboard));

		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(result);
		pw.append(json);
		System.out.println(json);
		/*
		pw.append("{\"iboard\":")
		.append(String.valueOf(result.getIboard()))
		.append(", \"title\":")
		.append("\"")
		.append(result.getTitle())
		.append("\", \"ctnt\": \"")
		.append(result.getCtnt())
		.append("\"}");
		*/
		//{"iboard" : 28, "title" : "안녕", "ctnt":"반갑습니다"}
	}

}
