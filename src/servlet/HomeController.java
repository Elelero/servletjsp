package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name="HomeController", urlPatterns="/HomeController")
//web.xml에 매핑되어 있어서 현재는 주석처리..!
public class HomeController extends HttpServlet {
	
	//클라이언트가 요청할 때 마다 콜백 (요청방식과는 상관없음)
	//역할: 요청처리
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeController.service() 실행");
		
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

}
