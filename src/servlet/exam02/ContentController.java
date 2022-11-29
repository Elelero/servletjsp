package servlet.exam02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.ContentController", urlPatterns = "/exam02/ContentController")
//@WebServlet(name = "exam02.ContentController", value ="/exam02/ContentController") 위에와 똑같은 코드임
public class ContentController extends HttpServlet {
	
	//서블릿 객체가 생성된 후 즉시, 딱 1번 콜백(=어떤 사건이 도래했을 때 실행하는 것)
	//역할: 서블릿 객체의 초기화 작업
	/*@Override
	public void init(ServletConfig config) throws ServletException {
		//서블릿 객체의 초기화 코드
		System.out.println("exam02.ContentController.init() 실행");
		
	}*/
	
	//클라이언트가 요청할 때 마다 콜백 (요청방식과는 상관없음)
	//역할: 요청처리
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/content.jsp").forward(request, response);
	}
	
	/*//클라이언트가 GET 방식으로 요청할 때 마다 콜백
	//역할: 요청처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/get.jsp").forward(request, response);
	}
	
	//클라이언트가 POST 방식으로 요청할 때 마다 콜백
	//역할: 요청처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/post.jsp").forward(request, response);
	}*/
}
