package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
//	HttpServletRequest - 클라이언트에서 전송한 요청정보들을 객체
//	HttpServletResponse - 클라이언트에 응답할 응답정보들을 객체

	public void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("FirstServlet 실행");
	}
}
