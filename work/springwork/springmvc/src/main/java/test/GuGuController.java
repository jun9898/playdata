package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuGuController {
	
	@RequestMapping("/gugu")
	public ModelAndView printgugu() {
		String msg = "";
		ModelAndView gugudan = new ModelAndView();
		for (int i = 1; i <= 9; i++) {
			msg += "7 * " + i + " = " + (7*i) + " " + "\n";
			System.out.println(msg);
		}
		gugudan.addObject("msg", msg);
		gugudan.setViewName("main/gugu");
		return gugudan;
	}

}
