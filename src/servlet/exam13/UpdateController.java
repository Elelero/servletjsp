package servlet.exam13;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import util.Pager;


@WebServlet(name="exam13.ContentController", urlPatterns="/exam13/ContentController")
public class UpdateController extends HttpServlet {
	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/exam13/content.jsp").forward(request, response);
	}
	
}
