package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;
import jdbc.MemberDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();

		String id =  request.getParameter("id");
		String pass =  request.getParameter("pass");

		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.login(id, pass);
		
		String path="";
		
		if (member == null) {
			path = "member_mvc/login.jsp";
		} else {
			request.setAttribute("mydata", member);
			path = "/index.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
