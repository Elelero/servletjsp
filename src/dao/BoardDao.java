package dao;

import java.sql.Connection;

import dto.Board;

//모든 DAO에 커넥션 추가
public class BoardDao {
	public void insert(Board board, Connection conn) {
		System.out.println("DB에 board 정보를 저장했습니다.");
	}
}
