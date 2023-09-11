package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptMemberListServlet
 */
@WebServlet(name = "deptlist", urlPatterns = { "/dept/list.do" })
public class DeptMemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();

		System.out.println("<h1>출력 테스트</h1>");
		
		DeptMemberDAO dao = new DeptMemberDAO();
		dao.getMemberList();
		ArrayList<DeptMemberDTO> memberlist = dao.getMemberList();
		
		pw.println("<h1> 회원목록 보기 </h1>");
		pw.println("<hr>");
		pw.println("<table border='1' width = '600'>");
		pw.println("<tr>");
		pw.println("<td>부서번호</td><td>부서이름</td><td>전화번호</td><td>주소</td><td>삭제</td>");
		pw.println("</tr>");
		for(DeptMemberDTO member : memberlist) {
			pw.println("<tr>");
			pw.println("<td>" + member.getDeptno() + "</td>");
			pw.println("<td>" + member.getDeptname() + "</td>");
			pw.println("<td>" + member.getTel() + "</td>");
			pw.println("<td>" + member.getAddr() + "</td>");
			// 삭제 기능을 구현한 서블릿을 요펑 (PK에 해당하는 id를 넘기기)
			pw.println("<td><a href='/serverweb/dept/delete.do?id=" + member.getDeptno() + "'> 삭제</a></td>");
			pw.println("</tr>");
		}
		pw.println("</table>");
	}

}
