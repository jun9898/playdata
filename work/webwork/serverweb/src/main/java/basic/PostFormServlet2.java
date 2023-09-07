package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "post2", urlPatterns = { "/post2.do" })
public class PostFormServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
									throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		Map<String,String[]> requestMap = req.getParameterMap();
//		1. map의 키를 추출
//		Set<String> keylist = requestMap.keySet();
//		for (String key : keylist) {
//			String[]values = requestMap.get(key);
//			for (String data : values) {
//				pw.print("<h1>" + key + " : " + data);
//			}
//		}

//		 클라이언트가 입력한 데이터를추출
		String id = req.getParameter("userId");
		String name = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String[] item = req.getParameterValues("item");
		String str = "";
		for (String it : item) {
			str += it + " ";
		}
		
//		 클라이언트에 응답할 페이지를 생성
		pw.print("<h1>아이디 : " + id + "</h1>");
		pw.print("<h1>성명 : " + name + "</h1>");
		pw.print("<h1>패스워드 : " + pass + "</h1>");
		pw.print("<h1>성별 : " + gender + "</h1>");
		pw.print("<h1>직업 : " + job + "</h1>");
//		pw.print("<h1>좋아하는 항목 : " + str + "</h1>");
		pw.print("<h1>좋아하는 항목 : " + Arrays.toString(item) + "</h1>");

	}
}
