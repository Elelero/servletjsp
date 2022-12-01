package servlet.exam05;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam05.HttpHeaderInfoController", urlPatterns="/exam05/HttpHeaderInfoController")
public class HttpHeaderInfoController extends HttpServlet {

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//시작행 정보얻기
		String method = request.getMethod();
		System.out.println("요청방식: " + method);

		String requestURL = request.getRequestURL().toString();
		System.out.println("Request URL: " + requestURL);
		
		String requestURI = request.getRequestURI();
		System.out.println("Request URI:" + requestURI);

		
		String contextPath = request.getContextPath();
		System.out.println("Context Path: " + contextPath);
		
		String queryString = request.getQueryString();
		System.out.println("Query String: " + queryString);
		
		//헤더행 정보얻기
		String userAgent = request.getHeader("User-Agent");
		System.out.println("User-Agent: " + userAgent);
		
		//클라이언트의 IP 정보얻기
		String remoteAddr = request.getRemoteAddr();
		System.out.println("Remote Address: " + remoteAddr); //TCP 통신이기떄문에 IP 정보를 얻을 수 있음
		
		//redirect
		response.sendRedirect("ContentController"); //상대경로: 현재경로에서 끝부분만 변경하겠다는 의미
	}
	
}
