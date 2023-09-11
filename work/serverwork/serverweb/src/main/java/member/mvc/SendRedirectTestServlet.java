package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendRedirectTestServlet")
public class SendRedirectTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		
		System.out.println("sendRedirect연습 - SendRedirextTestServlet실행");
		pw.println("<h1>요청재지정연습 - sendRedirect</h1>");
		
		// 요청재지정
		response.sendRedirect("serverweb/viewbasic/result.html");
	}

}
