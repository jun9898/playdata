package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청과 응답정보에 한글 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		
		//요청정보를 추출
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String method = request.getParameter("method");
		int num2 = Integer.parseInt(request.getParameter("num2"));
		//비지니스메소드 호출
		Calc obj = new Calc();
		int result = obj.calc(num1, method, num2);
		
		//응답화면 생성
		pw.print("<h1>계산결과</h1>");
		pw.print("<hr/>");
		pw.print("<h3>num1의 "+num1+"과 num2의 "+num2+" 연산한 결과는 "+result+"입니다.</h3>");
		
	}
}






























