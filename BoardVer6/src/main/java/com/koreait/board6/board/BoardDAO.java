package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	
	public static int getAllpage(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select ceil(count(*) / ?) from t_board"
				+ " where title like ?";
		
		int result = 0;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getPage());
			ps.setString(2, "%"+param.getSearch()+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
		
	}
	
	public static List<BoardVO> selBoardList(BoardVO param) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				+ "	A.iboard, A.title, A.iuser, A.regdt "
				+ "	, B.unm "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " where title like ?"
				+ " ORDER BY iboard DESC "
				+ " limit ?, ?";		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+param.getSearch() +"%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
			rs = ps.executeQuery();			
			while(rs.next()) {
				BoardVO vo = new BoardVO();								
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		BoardVO data = null;
		
		String sql = " SELECT A.title, A.regdt, A.ctnt, A.iuser, B.unm "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				int iuser = rs.getInt("iuser");
				String unm = rs.getString("unm");
								
				data = new BoardVO();
				data.setIboard(iboard);
				data.setTitle(title);
				data.setCtnt(ctnt);
				data.setRegdt(regdt);
				data.setIuser(iuser);
				data.setUnm(unm);		
			}			
			return data;	
		} catch (Exception e) {
			e.printStackTrace();
			return data;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}
}
