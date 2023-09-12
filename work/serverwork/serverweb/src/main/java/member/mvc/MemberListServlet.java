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
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "mvc_list", urlPatterns = { "/mvc/member/list.do" })
public class MemberListServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		/*
		 * response.setContentType("text/html;charset=UTF-8"); PrintWriter pw =
		 * response.getWriter();
		 */
		System.out.println("<h1>출력 테스트</h1>");
		
		MemberDAO dao = new MemberDAO();
		dao.getMemberList();
		ArrayList<MemberDTO> memberlist = dao.getMemberList();

		request.setAttribute("mydata", memberlist);
		
		// 요청재지정
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/list.jsp");
		rd.forward(request, response);
		
		
		
	}

}
