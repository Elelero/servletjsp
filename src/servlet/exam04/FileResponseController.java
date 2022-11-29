package servlet.exam04;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="exam04.FileResponseController", urlPatterns="/exam04/FileResponseController")
public class FileResponseController extends HttpServlet {

	//클라이언트가 요청할때 마다 실행
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String fileName = "photo1.jpg";
		String fileName = "사진1.jpg"; //한글로 작성하면..? 어케될까?
		String filePath = "C:/Temp/photo1.jpg";
		String contentType = "image/jpg";
		
		//HTTP 응답에 Content-Type 헤더를 추가 (MIME)
		response.setContentType(contentType);
			// == response.setHeader("Content-Type", contentType); 이 방식대로 헤더 추가 가능
		
		//Browser의 종류 얻기
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident")||userAgent.contains("MSIE")) { 
			//IE(인터넷 익스플로어17)일 경우
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else { 
			//Chorme, Edage, FireFox, Safari... 일 경우
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		
		//HTTP 응답에 Content-Disposition 헤더를 추가
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		
		//HTTP 응답 본문에 파일 데이터 출력하기
		ServletOutputStream sos = response.getOutputStream(); //전송대상이 이미지이므로, outputstream사용
		//(PrintWriter pw = response.getWriter(); 문자일때만 사용가능)
		
		//이미지 전송방법1 (가장 쉬운방법)
		Path path = Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		sos.close();
		
		//이미지 전송방법2 (이것이자바다 p808)
		/*FileInputStream fis = new FileInputStream(filePath);
		byte[] data = new byte[1024];
		while(true) {
			int readByteNum = fis.read(data);
			if(readByteNum == -1) break;
			sos.write(data, 0, readByteNum);
		}
		sos.flush();
		fis.close();
		sos.close();*/
		
	}
	
}
