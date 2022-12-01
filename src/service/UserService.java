package service;

import javax.servlet.ServletContext;

import dao.UserDao;
import dto.User;

public class UserService {
	//메소드 안에 매개변수로 쓰기 싫을 때, 생성자를 이용
	private ServletContext application;
	
	public UserService(ServletContext application) {
		this.application = application;
	}
	
	public void join(User user) {
		System.out.println("회원가입을 합니다.");
		UserDao userDao = (UserDao) application.getAttribute("userDao");
		userDao.insert(user, null);
	}
}
