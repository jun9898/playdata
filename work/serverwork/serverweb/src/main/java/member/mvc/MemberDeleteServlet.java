package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.MemberDAO;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/mvc/member/delete.do")
public class MemberDeleteServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();

		String id =  request.getParameter("id");

		MemberDAO dao = new MemberDAO();
		int result = dao.delete(id);
		
//		pw.print("<h1>" + result + "개 삭제 성공</h1>");
		
//		요청재지정
		response.sendRedirect("/serverweb/mvc/member/list.do");

	}

}
