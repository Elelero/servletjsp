package servlet.exam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet(name="exam04.JsonResponseController", urlPatterns="/exam04/JsonResponseController")
public class JsonResponseController extends HttpServlet {

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//MIME 타입
		response.setContentType("application/json; charset=UTF-8");
		
		//{"bno:1, "btitle":"자바", "bcontent":"프로그래밍 언어"}
		JSONObject root = new JSONObject();
		root.put("bno", 1);
		root.put("btitle", "자바");
		root.put("bcontent", "프로그래밍 언어");
		String json = root.toString();
		
		//ServletOutputStream os = response.getOutputStream(); //byte 기반 스트림
		PrintWriter pw = response.getWriter(); //문자기반 스트림 -> 얘가 더 나음
		pw.println(json);
		pw.flush();
		pw.close();
		
	}
	
}
