package com.playdata.booterp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.booterp.board.BoardService;
import com.playdata.booterp.dto.BoardDTO;

@Controller
@RequestMapping("/ajax")
public class AjaxTestController {
	
	BoardService boardService;
	
	@Autowired
	public AjaxTestController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	@GetMapping("/view")
	public String view() {
		return "json/ajax";
	}

	@GetMapping("/exam")
	public String exam() {
		return "json/ajax_exam";
	}
	
	@GetMapping("/noajax")
	public String noajax(String id, Model model) {
		// Ajax로 요청하지 않고 일반적인 방법으로 요청하는 경우
		String msg = "";
		if(id.equals("jang")) {
			msg="사용 불가능 아이디";
		} else {
			msg="사용 가능 아이디";
		}
		model.addAttribute("msg", msg);
		return "json/ajax";
	}
	
	@GetMapping(value="/ajaxtest01", produces = "application/text;charset=utf-8")
	@ResponseBody // @ResponseBody를 정의해야 뷰가 아니라 String으로 response된다.
	public String ajaxtest(String id) {
		String msg = "";
		if(id.equals("jang")) {
			msg="사용 불가능 아이디";
		} else {
			msg="사용 가능 아이디";
		}
		return msg;
		
	}

	@GetMapping("/gugu")
	@ResponseBody // @ResponseBody를 정의해야 뷰가 아니라 String으로 response된다.
	public String getgugu(String dan) {
		int num = Integer.parseInt(dan);
		String msg2 = "";
		for (int i = 1; i < 10; i++) {
			msg2 += dan + " * " + i + " = " + (num*i) + "</br>";
		}
		return msg2;
	}
	
	@GetMapping("/exam01")
	@ResponseBody
	public BoardDTO responseObj(String boardno) {
		return boardService.getBoardInfo(boardno);
	}

	@CrossOrigin
	@GetMapping("/exam02")
	@ResponseBody
	public List<BoardDTO> responseObj2() {
		// 내장되어있는 jackjson-databind라이브러리가 실행되며 자동으로 json array로 변환되어 return한다
		// 만약 DTO 여러개를 이용해서 JSON Array를 만드는 경우는 Jaxkson 라이브러리의 mapper 를 이용해서 직접 json으로 변환하도록 처리한다.
		return boardService.boardList();
	}

	@GetMapping("/exam03")
	@ResponseBody
	public List<BoardDTO> responseObj3(String category) {
		return boardService.findByCategory(category);
	}
}
