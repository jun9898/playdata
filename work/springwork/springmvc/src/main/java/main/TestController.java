package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/getdata")
	public  ModelAndView getData() {
		ModelAndView mav = new ModelAndView();
		// ���������� �����ϱ� = request.setAttribute("name", ������ü)
		mav.addObject("msg", "���������� ������ ������ ======");
		// �� ���� �����ϱ� - ��û�������� ���� �̸��� ����
		mav.setViewName("main/result");
		return mav;
		
	}

}
