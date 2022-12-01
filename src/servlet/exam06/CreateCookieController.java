package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam06.CreateCookieController", urlPatterns="/exam06/CreateCookieController")
public class CreateCookieController extends HttpServlet {

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 생성
		Cookie cookie1 = new Cookie("useremail", "winter@mycompany.com");
		//cookie1.setDomain("localhost"); //해당 도메인으로 갈때만 Cookie를 전달
		//cookie1.setPath("/"); 		  //해당 경로로 요청할때만 Cookie를 전달
		//cookie1.setMaxAge(60); 		  //유지시간 설정(초*분*시) => 파일시스템에 저장
		//cookie1.setHttpOnly(true);	  //자바스크립트에서 쿠키를 읽지 못하도록 하는 설정
		//cookie1.setSecure(true);		  //https에서만 쿠키를 전달
		
		//쿠키를 응답헤더에 추가하기
		response.addCookie(cookie1);
		
		//쿠키 생성
		Cookie cookie2 = new Cookie("userid", "winter");
		response.addCookie(cookie2);
		
		response.sendRedirect("ContentController");
	}
	
}
