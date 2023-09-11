package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.MemberDAO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet(name = "mem_insert", urlPatterns = { "/member/insert.do" })
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
		
		//비지니스메소드 호출
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pass, name, addr, info);
		int result = dao.insert(member);
		//결과화면 생성
		pw.print("<h1>"+result+"개 삽입성공</h1>");
	}

}








