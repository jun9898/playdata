package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//요청과 응답정보에 한글 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		//요청정보추출
		String id = request.getParameter("userId");
		String name = request.getParameter("userName");
		String pass = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] item = request.getParameterValues("item");
		String str = "";
		for(String data:item) {
			str = str + data+" ";
		}
		//응답할 페이지 생성
		pw.println("<h1>customer</h1>");
		pw.println("<hr/>");
		pw.println("<h1>아아디:"+id+"</h1>");
		pw.println("<h1>성명:"+name+"</h1>");
		pw.println("<h1>패스워드:"+pass+"</h1>");
		pw.println("<h1>성별:"+gender+"</h1>");
		pw.println("<h1>직업:"+job+"</h1>");
		pw.println("<h1>좋아하는 항목:"+str+"</h1>");
		pw.println("<h1>아아디:"+Arrays.toString(item)+"</h1>");
	}

}







