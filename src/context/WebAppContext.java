package context;

import javax.servlet.ServletContext; 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import dao.BoardDao;
import dao.UserDao;
import service.BoardService;
import service.UserService;

public class WebAppContext implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext가 생성완료됨");
		
		//ServletContext 객체 얻기
		ServletContext application = sce.getServletContext();

		//ConnectionPool(javax.sql.DataSource) 객체 얻기
		DataSource dataSource = ConnectionProvider.getDataSource();
		application.setAttribute("dataSource", dataSource);
		
		//SerlvetContext 객체에 데이터(객체) 저장  <- Dao 객체 저장!
		application.setAttribute("userDao", new UserDao());
		application.setAttribute("boardDao", new BoardDao());

		//SerlvetContext 객체에 데이터(객체) 저장  <- Service 객체 저장!
		application.setAttribute("userService", new UserService(application));
		application.setAttribute("boardService", new BoardService(application));
	}
}
