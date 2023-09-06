package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet {
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet 객체생성");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init()....");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("service()....");
		// 요청방식에 따라 doGet과 doPost가 호출되도록 작업
		if (req.getMethod().equals("GET")) {
			doGet(req, res);
		} else {
			doPost(req, res);
		}
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()....");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()....");
	}

	// 서블릿객체가 메모리에서 해제될때 호출
	// - 서블릿 객체가 컴파일 되는 경우
	// - WAS가 reload 될때
	// - context가 reload될때
	@Override
	public void destroy() {
		System.out.println("destroy()....");
	}

	
	


}
