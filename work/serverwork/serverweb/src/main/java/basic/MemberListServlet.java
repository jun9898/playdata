package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.MemberDAO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "list", urlPatterns = { "/member/list.do" })
public class MemberListServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();

		System.out.println("<h1>출력 테스트</h1>");
		
		MemberDAO dao = new MemberDAO();
		dao.getMemberList();
		ArrayList<MemberDTO> memberlist = dao.getMemberList();
		
		pw.println("<h1> 회원목록 보기 </h1>");
		pw.println("<hr>");
		pw.println("<table border='1' width = '600'>");
		pw.println("<tr>");
		pw.println("<td>아이디</td><td>패스워드td><td>성명td><td>주소td><td>가입일</td>"
				+ "<td>포인트</td><td>기타정보</td><td>삭제</td>");
		pw.println("</tr>");
		for(MemberDTO member : memberlist) {
			pw.println("<tr>");
			pw.println("<td>" + member.getId() + "</td>");
			pw.println("<td>" + member.getPass() + "</td>");
			pw.println("<td>" + member.getName() + "</td>");
			pw.println("<td>" + member.getAddr() + "</td>");
			pw.println("<td>" + member.getRegdate() + "</td>");
			pw.println("<td>" + member.getPoint() + "</td>");
			pw.println("<td>" + member.getInfo() + "</td>");
			// 삭제 기능을 구현한 서블릿을 요펑 (PK에 해당하는 id를 넘기기)
			pw.println("<td><a href='/serverweb/member/delete.do?id=" + member.getId() + "'> 삭제</a></td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
		
		
		
	}

}
