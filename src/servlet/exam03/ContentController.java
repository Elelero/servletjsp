package servlet.exam03;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentController extends HttpServlet {
	private String encoding;
	private String viewLocation;
	
	//클라이언트에서 최초로 서블릿을 요청했을 때, 딱 1번 실행!(load-on-startup 옵션이 없을 경우)
	//load-On-Startup이 있을 경우, Deployment시에 딱 1번 실행
	//(load-On-Startup을 작성하면 객체를 생성하는 단계를 생략하기 때문에 시간단축가능)
	//역할: service()/doGet()/doPost() 에서 사용하는 데이터를 초기화해주는 역할
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("exam03.ContentController.init() 실행");
		
		if(config.getInitParameter("encoding")==null) {
			encoding = "UTF-8";
		} else {
			encoding = config.getInitParameter("encoding");
		}
		
		if(config.getInitParameter("viewLocation")==null) {
			viewLocation = "/WEB-INF/views";
		} else {
			viewLocation = config.getInitParameter("viewLocation");
		}

		/*System.out.println(config.getInitParameter("encoding"));
		System.out.println(config.getInitParameter("viewLocation"));*/
	}
	
	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doGet() 실행");
		request.getRequestDispatcher("/WEB-INF/views/exam03/content.jsp").forward(request, response);
	}

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("exam03.ContentController.doPost() 실행");
		
		request.setCharacterEncoding(encoding); //한글로 인코딩제대로 될 수 있게 해줌
		
		String param1 = request.getParameter("param1");
		System.out.println("param1: " + param1);
		
		request.getRequestDispatcher(viewLocation + "/exam03/content.jsp").forward(request, response);
	}
	
	//서블릿 제거할 때(Undeployment 될 때)
	@Override
	public void destroy() {
		System.out.println("exam03.ContentController.destroy() 실행");
	}
	
}
