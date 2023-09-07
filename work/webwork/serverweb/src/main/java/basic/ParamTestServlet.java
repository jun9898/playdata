package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamTestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 요청정보에 한글을 설정 (한글인코딩 적용)
		req.setCharacterEncoding("UTF-8");
		
		// 응답데이터의 형식과 인코딩 설정
		resp.setContentType("tesst/html;charset=UTF-8");

		// 클라이언트에 응답할 데이터를 출력하기 위한 스트림 객체를 구하기
		PrintWriter pw = resp.getWriter();

		// 클라이언트가 입력한 데이터를 추출
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + pass);
		
		// 클라이언트에 응답할 페이지를 생성
		pw.print("<h1>아이디" + id + "</h1>");
		pw.print("<h1>패스워드" + id + "</h1>");
	}
}
