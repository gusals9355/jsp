package com.koreait.board6.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.Const;
import com.koreait.board6.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		if(search == null) {
			search = "";
		}
		int page = MyUtils.getParamInt(Const.PAGE, request);
		if(page ==0) {
			page =1;
		}
		int recordCnt = 10;
		int sIdx = (page-1) * recordCnt;
		
		BoardVO param = new BoardVO();
		param.setsIdx(sIdx);
		param.setPage(recordCnt);
		param.setSearch(search);
		
		request.setAttribute("totalPage", BoardDAO.getAllpage(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
		
		MyUtils.openJSP("boardlist", "board/boardList", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}