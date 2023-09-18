package fw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FrontServlet")
@WebServlet(name="front", urlPatterns = {"*.do","*.html","*.jsp","/"})

public class FrontServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		1. 요청정보를 분석해서 추출 - 어떤 path로 요청이 들어왔는지 분석하기
		System.out.println("frontController 컨트롤러 패턴");
		System.out.println("request.getContextPath() => " + request.getContextPath());
		System.out.println("request.getRequestURI() => " + request.getRequestURI());
		System.out.println("request.getRemoteAddr() => " + request.getRemoteAddr());
		
		String contextPath = request.getContextPath();
		String requestUri = request.getRequestURI();
		String path = requestUri.substring(contextPath.length());
		System.out.println("path => "+ path);
		
//		2. 추출한 요청 path로 등록된 클래스를 찾아서 가져오는 작업
//		 => 어노테이션으로 등록, xml로 등록, 설정파일로 등록
//		 => 문자열로 등록된 실행객체를 if문으로 처리
		RequestMapping rm = new RequestMapping();
		Action action = rm.mapping(path);
//		3. Action 의 run 메소드를 호출
		action.run(request, response);
//		4. run 메소드의 실행결과를 받아서 응답한 view를 찾기
//		5. 응답 view를 찾아서 forward하거나 redirect하도록 정의

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
