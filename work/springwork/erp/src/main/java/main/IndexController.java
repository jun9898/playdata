package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.do")
	public String indexView() {
		System.out.println("index");
		return "index";
	}

	@RequestMapping("/emp/login.do")
	public String loginView() {
		System.out.println("login");
		return "login";
	}

	@RequestMapping("/menu/board.do")
	public String comuView() {
		System.out.println("c");
		return "menu/board";
	}
}
