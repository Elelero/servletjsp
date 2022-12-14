package servlet.exam05;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam05.ParamController", urlPatterns="/exam05/ParamController")
public class ParamController extends HttpServlet {

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String kind = request.getParameter("kind");
		String writer = request.getParameter("writer");
		String[] hobby = request.getParameterValues("hobby"); //복수값은 배열로
		
		System.out.println("pageNo: " + pageNo);
		System.out.println("kind: " + kind);
		System.out.println("writer: " + writer);
		System.out.println("hobby: " + Arrays.toString(hobby)); 
		
		response.sendRedirect("RequestParamInfoController");
	}

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String[] hobby = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String city = request.getParameter("city");
		
		System.out.println("email: " + email);
		System.out.println("pwd: " + pwd);
		System.out.println("hobby: " + Arrays.toString(hobby)); 
		System.out.println("job: " + job);
		System.out.println("city: " + city);

		response.sendRedirect("RequestParamInfoController");
	}
	
	
}
