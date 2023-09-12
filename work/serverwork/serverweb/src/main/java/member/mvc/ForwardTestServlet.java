package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;
import dept.DeptMemberDTO;

@WebServlet(name ="forward", urlPatterns = {"/forward"})
public class ForwardTestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		
		System.out.println("forward연습 - forward실행");
		pw.println("<h1>요청재지정연습 - forward</h1>");
		MemberDTO dto = new MemberDTO("test", "1234", "전병준", "독산","test");
		
		request.setAttribute("mydata", dto);
		
		// 요청재지정
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/result.jsp");
		rd.forward(request, response);
		
	}

}
