package service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;
import util.Pager;

public class BoardService {
	//메소드 안에 매개변수로 쓰기 싫을 때, 생성자를 이용
	private ServletContext application;
	private DataSource ds;
	private BoardDao boardDao;
	
	//constructor
	public BoardService(ServletContext application) {
		this.application = application;
		boardDao = (BoardDao) application.getAttribute("boardDao");
		
		ds = (DataSource) application.getAttribute("dataSource");
		/*try {
			//InitialContext ic = new InitialContext();
			//ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	//method
	public void write(Board board) {
		System.out.println("게시물을 저장합니다.");
		boardDao.insert(board, null);
	}

	//method
	public void write2(Board board) {
		System.out.println("게시물을 저장합니다.");
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			boardDao.insert2(board, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch(Exception e) {}
		}
	}

	//method: (페이지) 전체 행의 수 얻기
	public int getTotalBoardNum() {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = boardDao.countRows(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
	
	//method : 게시글 목록(페이징처리)
	public List<Board> getPageList(Pager pager) {
		List<Board> result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = boardDao.selectPageList(pager, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
	//method: Board 객체 가져오기
	public Board getBoard(int bno) {
		Board result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = boardDao.selectBoard(bno, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch(Exception e) {}
		}
		
		return result;
	}
	
}
