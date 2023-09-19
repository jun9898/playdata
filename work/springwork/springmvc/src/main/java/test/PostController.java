package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PostController {
	

	@RequestMapping(value = "/showform")
	public ModelAndView showForm() {
		ModelAndView mav = new ModelAndView("main/postform");
		return mav;
	}
	
	@RequestMapping(value = "/showdata", method = RequestMethod.POST)
	public ModelAndView showData(PostDTO dto) {
		ModelAndView mav = new ModelAndView("main/showform");
		mav.addObject("postdto", dto);
		return mav;
	}

}
