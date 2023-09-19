package test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamTestController {
	
	@RequestMapping("/showview")
	public String param() {
		return "main/param";
	}
	
	@RequestMapping(value = "/paramtest", method = RequestMethod.GET)
	public ModelAndView getparamtest(HttpServletRequest request,
			@RequestParam("data")String mydata, String info) {
		ModelAndView mav = new ModelAndView("main/paramresult");
		System.out.println("get방식으로 요청 ======> " + mydata);
		System.out.println("get방식으로 요청 ======> " + info);
		mav.addObject("data",mydata);
		return mav;
	}

	@RequestMapping(value = "/paramtest", method = RequestMethod.POST)
	public ModelAndView postparamtest( String id, String pass) {
		ModelAndView mav = new ModelAndView("main/paramresult");
		System.out.println(id);
		System.out.println(pass);
		mav.addObject("id", id);
		mav.addObject("pass", pass);
		return mav;
	}

	@RequestMapping(value = "/paramtest2", method = RequestMethod.POST)
	public ModelAndView postparamtest(TestDTO dto) {
		ModelAndView mav = new ModelAndView("main/paramresult");
		System.out.println("post방식으로 요청" + dto);
		mav.addObject("id", dto.getId());
		mav.addObject("pass", dto.getPass());
		return mav;
	}

}
