package springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringJdbcTestController {
	
	@Autowired
	SpringJdbcTestService service;
	@RequestMapping("/springjdbc/test")
	public String empTest() {
		service.getEmpCount();
		return "main/index";
		
	}

}
