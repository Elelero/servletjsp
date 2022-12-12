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
public class ContentController extends HttpServlet {
	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 1000개 생성하는 코드
		//BoardService 객체 가져오기
		/*BoardService boardService = (BoardService) request.getServletContext().getAttribute("boardService");
		
		for(int i=0; i<1000; i++) {
			Board board = new Board();
			board.setBtitle("제목: " + i);
			board.setBcontent("내용" + i);
			board.setBwriter("winter");
			boardService.write2(board);
		}*/
		
		//pageNo 얻기 (페이징 처리)
		String strPageNo = request.getParameter("pageNo");
		
		if(strPageNo == null) {
			strPageNo = "1";
		}
		
		int pageNo = Integer.parseInt(strPageNo);
		
		//BoardService 객체 얻기
		ServletContext application = request.getServletContext();
		BoardService boardService = (BoardService) application.getAttribute("boardService");

		//페이징 대상이되는 전체 행수 얻기
		int totalBoardNum = boardService.getTotalBoardNum();
		
		//Pager 생성
		Pager pager = new Pager(10, 5, totalBoardNum, pageNo);
		
		//pageNo에 해당하는 게시물 가져오기
		List<Board> pageList = boardService.getPageList(pager);
		
		//JSP에서 사용할 수 있도록, request 저장범위에 저장
		request.setAttribute("pager", pager);
		request.setAttribute("pageList", pageList);
		
		request.getRequestDispatcher("/WEB-INF/views/exam13/content.jsp").forward(request, response);
	}
	
}