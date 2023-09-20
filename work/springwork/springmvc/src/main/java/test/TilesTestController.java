package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesTestController {
	
	@RequestMapping("/tiles/post")
	public String showPostView() {
		System.out.println("post");
		return "postview";
	}

	@RequestMapping("/tiles/login")
	public String tilesLogin() {
		System.out.println("login");
		return "emp/login";
	}

	@RequestMapping("/tiles/insert")
	public String tilesInsert() {
		System.out.println("insert");
		return "tiles/insert";
	}

}
