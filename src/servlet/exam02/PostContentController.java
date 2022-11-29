package servlet.exam02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.PostController", urlPatterns = "/exam02/PostController")
//@WebServlet(name = "exam02.ContentController", value ="/exam02/ContentController") 위에와 똑같은 코드임
public class PostContentController extends HttpServlet {
	//클라이언트가 POST 방식으로 요청할 때 마다 콜백
	//역할: 요청처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/post.jsp").forward(request, response);
	}

}
