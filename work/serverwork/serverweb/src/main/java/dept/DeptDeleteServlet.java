package dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptDeleteServlet
 */
@WebServlet(name = "dept_delete", urlPatterns = { "/dept/delete.do" })
public class DeptDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();

		String id =  request.getParameter("id");

		DeptMemberDAO dao = new DeptMemberDAO();
		int result = dao.delete(id);
		
		pw.print("<h1>" + result + "개 삭제 성공</h1>");

	}
}
