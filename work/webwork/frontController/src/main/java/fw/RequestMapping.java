package fw;

import member.LoginAction;
import member.MemberInsertAction;
import member.ProductListAction;

/*
	FrontServlet이 넘겨준 요청 path를 가지고 실제 실행할 클래스의 객체를 만들어서 리턴하는 작업을 수행
	=> 미리 요청 path별 실행할 길제 클래스를 등록한 설정파일을 보고 찾을 수 있도록 하거나 
	annotation으로 정의하면 분석해서 실행할 수 있도록 코드가 작성되어 있어야 한다.
	보통 설정은 설정파일 (xml, properties파일) 이나 빈, 혹은 어노테이션으로 하도록 코드 정의
	그러나 우리는 frontController패턴이 어떻게 동작하는지 보는 것이므로 if~else if 로 처리
*/

public class RequestMapping {
	public Action mapping(String path) {
		Action action = null;
		// 매개변수로 전달된 path를 분석해서 등록된 객체를 찾아서 리턴하는 코드가 작성되어 있어야 한다.
		if(path.equals("/member/insert.do")) { // insertAction
			// insert기능을 수행하는 객체를 리턴
			action = new MemberInsertAction();
		} else if (path.equals("/product/list.do")) { // ProductListAction
			// 상품조회하는 기능을 수행하는 객체를 리턴
			action = new ProductListAction();
		} else if (path.equals("/member/login.do")) { // ProductListAction
			// 로그인하는 기능을 수행하는 객체를 리턴
			action = new LoginAction();
		}
		return action;
		
		
	}
}
