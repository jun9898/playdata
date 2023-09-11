package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFormServlet2
 */
@WebServlet(name = "post2", urlPatterns = { "/post2.do" })
public class PostFormServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
								throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw =  response.getWriter();
		Map<String,String[]> requestMap =  request.getParameterMap();
		//1. map의 키를 추출
		Set<String> keylist = requestMap.keySet();
		for(String key: keylist) {
			String[] values = requestMap.get(key);
			for(String data:values) {
				System.out.println("key="+key+",value="+data);	
			}
		}
	}

}









