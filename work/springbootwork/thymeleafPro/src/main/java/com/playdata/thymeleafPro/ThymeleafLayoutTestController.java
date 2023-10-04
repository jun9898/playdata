package com.playdata.thymeleafPro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("layout")
public class ThymeleafLayoutTestController {
	
	@GetMapping("/fragmenttest")
	public String fragment_test() {
		return "fragment/main";
	}

	@GetMapping("/prdlist")
	public String layout_test() {
		System.out.println("컨트롤러 테스트");
		return "product/productlist";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	

}
