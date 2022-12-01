package service;

import javax.servlet.ServletContext;

import dao.BoardDao;
import dto.Board;

public class BoardService {
	//메소드 안에 매개변수로 쓰기 싫을 때, 생성자를 이용
	private ServletContext application;
	
	public BoardService(ServletContext application) {
		this.application = application;
	}
	
	//method
	public void write(Board board) {
		System.out.println("게시물을 저장합니다.");
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		boardDao.insert(board, null);
	}
	
}
