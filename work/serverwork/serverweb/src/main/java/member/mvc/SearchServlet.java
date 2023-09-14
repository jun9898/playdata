package member.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.MemberDTO;
import jdbc.MemberDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "mvc_search", urlPatterns = { "/mvc/search.do"} )
public class SearchServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		
		request.setCharacterEncoding("UTF-8");
		
		String addr = request.getParameter("search");

		MemberDAO dao = new MemberDAO();

		ArrayList<MemberDTO> memberlist = dao.search(addr);

		request.setAttribute("mydata", memberlist);

		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/searchresult.jsp");
		rd.forward(request, response);

	}

}
