package com.playdata.jpaTest.springdata.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	// 간단한 테스트를 위해서 모두 생략하고 컨트롤러에서 직접 DAO를 호출
	// View -> Controller -> Service -> DAO -> Repository
	BoardDAO dao;

	@Autowired
	public BoardController(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	
	@GetMapping("/jpa/page/list")
	// spring data 페이징 처리를 위한 컨트롤러
	public String jpaFindAll(Model model, String pageNo) {
		List<BoardEntity> list = dao.findAll(Integer.parseInt(pageNo));
		model.addAttribute("boardlist", list);
		return "jpa/boardlist";
	}
	

	

}
