package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRequestTest extends HttpServlet {
	public void  doGet(HttpServletRequest req, HttpServletResponse res) 
											throws ServletException,IOException{
		System.out.println("get방식으로 요청");
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException,IOException{
		System.out.println("post방식으로 요청");
	}
}
