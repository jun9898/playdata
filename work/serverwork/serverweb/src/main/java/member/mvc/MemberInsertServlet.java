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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet(name = "mvc_insert", urlPatterns = { "/mvc/member/insert.do" })
public class MemberInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청과 응답정보에 한글 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		
		//요청정보추출
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String info = request.getParameter("info");
		
		System.out.println("test");
		
		//비지니스메소드 호출
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pass, name, addr, info);
		int val = dao.insert(member);
		//결과화면 생성
		request.setAttribute("mydata", val);
		RequestDispatcher rd = request.getRequestDispatcher("/member_mvc/result.jsp");
		rd.forward(request, response);
	}

}








