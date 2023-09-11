package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet(name = "insert", urlPatterns = { "/dept/insert.do" })
public class DeptInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();

		String no = request.getParameter("deptno");
		String name = request.getParameter("deptname");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");

		DeptMemberDAO dao = new DeptMemberDAO();
		DeptMemberDTO member = new DeptMemberDTO(no, name, tel, addr);
		int result = dao.insert(member);

		pw.print("<h1>"+result+"개 삽입성공</h1>");
	}


}
