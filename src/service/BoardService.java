package service;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;

public class BoardService {
	//메소드 안에 매개변수로 쓰기 싫을 때, 생성자를 이용
	private ServletContext application;
	private DataSource ds;
	
	public BoardService(ServletContext application) {
		this.application = application;
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//method
	public void write(Board board) {
		System.out.println("게시물을 저장합니다.");
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		boardDao.insert(board, null);
	}

	//method
	public void write2(Board board) {
		System.out.println("게시물을 저장합니다.");
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			boardDao.insert2(board, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close(); } catch(Exception e) {}
		}
	}
	
}
