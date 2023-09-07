package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));

		String method = req.getParameter("method");
		
		// 비지니스 메소드 호출
		Calc calc = new Calc();
		

		pw.print("<h1>계산결과</h1><hr/>");

		pw.print("<h2>num1의 " + num1 +"과 num2의 " + num2 + "를 연산한 결과는 " + calc.clac(num1, method, num2) + "입니다</h2>");


	}

}
