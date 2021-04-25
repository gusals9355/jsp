package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//데이터 베이스에 연결 메소드
	public void getCon() {
		try {
			Context initctx = new InitialContext();
			
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con = ds.getConnection(); //커넥션 연결해주는 메소드
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//전체글의 개수를 리턴하는 메소드
	public int getAllCount() {
		
		int count = 0;
		getCon();
		try {
			//쿼리준비
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			//쿼리 실행후 결과를 리턴
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //데이터가 있다면
				count = rs.getInt(1);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	//모든 (화면에 보여질 데이터를 10개씩 추출해서 리턴하는 메소드
	public Vector<BoardBean> getAllBoard(int startRow, int endRow) {
		Vector<BoardBean> v = new Vector<BoardBean>();
		
		getCon();
		try {
			//쿼리 작성
			String sql = "select * from (select A.*, @ROWNUM := @ROWNUM +1 AS Rnum from (select * from board order by ref desc, re_step asc)A, (select @ROWNUM:=0) TMP)"
					+ "where Rnum >= ? and Rnum <= ?";
			//쿼리 실행할 객체 선언
			pstmt = con.prepareStatement(sql);
			//?에 값을 대입
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			//데이터 개수가 몇개인지 모르기에 반복문을 이용하여 데이터를 추출
			while(rs.next()) { //값이 있다면 계속 반복함
				//데이터를 패키징(가방 = BoardBean클래스)를 이용해줌
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt(1));
				bean.setWirter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				v.add(bean);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
}












