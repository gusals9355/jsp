package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Database {
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet rs;
	
	public static void getCon() {
		try {
			Context initctx = new InitialContext();
			
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertBoard(BoardBean bean) {
		getCon();
		
		try {
			String sql = "insert into board(title, content) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getContent());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertMember(BoardMemberBean bean) {
		getCon();
		
		try {
			String sql = "insert into member2 values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getEmail());
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<BoardMemberBean> getId(BoardMemberBean bean){
		List<BoardMemberBean> list = new ArrayList<BoardMemberBean>();
		getCon();
		
		try {
			String sql = "select id, pw from member2 where id = ? and pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BoardBean> getAllBoard(){
		List<BoardBean> list = new ArrayList<BoardBean>();
		getCon();
		
		try {
			String sql = "select * from board order by no desc";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setNo(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				bean.setContent(rs.getString(3));
				bean.setReadCount(rs.getInt(4));
				bean.setReg_date(rs.getString(5));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardBean getOneBoard(int no){
		BoardBean bean = new BoardBean();
		getCon();
		
		try {
			String sql = "select * from board where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNo(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				bean.setContent(rs.getString(3));
				bean.setReadCount(rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	public void deleteBoard(int no) {
		getCon();
		
		try {
			String sql = "delete from board where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBoard(String title, String content, int no) {
		getCon();
		
		try {
			String sql = "update board set title=?, content=? where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readCountUp(int no) {
		int count=0;
		
		getCon();
		try {
			String getReadCountSql = "select readcount from board where no = ?";
			pstmt=con.prepareStatement(getReadCountSql);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				count++;
			}
			
			String sql = "update board set readcount = ? where no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertReple(int no, String id, String pw, String reple){
		getCon();
		try {
			String sql = "insert into member values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, reple);
			pstmt.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardBean> selectReple(int no) {
		List<BoardBean> list = new ArrayList<>();
		getCon();
		
		try {
			String sql = "select * from member where no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setNo(rs.getInt(1));
				bean.setId(rs.getString(2));
				bean.setPw(rs.getString(3));
				bean.setReple(rs.getString(4));
				list.add(bean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public BoardBean selectSearch(String search) {
		BoardBean bean = new BoardBean();
		String title = getTitle(search);
		getCon();
		try {
			String sql = "select * from board where title = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.executeQuery();
			if(rs.next()) {
				bean.setNo(rs.getInt(1));
				bean.setTitle(rs.getString(2));
				bean.setContent(rs.getString(3));
				bean.setReadCount(rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public String getTitle(String search) {
		String title="";
		getCon();
		try {
			String sql = "select title from board where title like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				title = rs.getString(1);
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return title;
	}
	

}