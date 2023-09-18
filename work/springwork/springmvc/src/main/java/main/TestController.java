package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/getdata")
	public  ModelAndView getData() {
		ModelAndView mav = new ModelAndView();
		// 공유데이터 저장하기 = request.setAttribute("name", 공유객체)
		mav.addObject("msg", "스프링에서 공해준 데이터 ======");
		// 뷰 정보 설정하기 - 요청재지정할 뷰의 이름을 설정
		mav.setViewName("main/result");
		return mav;
		
	}

}
