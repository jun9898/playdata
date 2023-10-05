package com.playdata.thymeleafPro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@GetMapping("/prdread")
	public String layout_read_test(Model model, String prdno, String prdname) {
		System.out.println(prdno);
		System.out.println(prdname);
		model.addAttribute("prdno", prdno);
		model.addAttribute("prdname", prdname);
		return "product/productRead";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	

}
