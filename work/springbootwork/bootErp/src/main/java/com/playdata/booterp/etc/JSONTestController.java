package com.playdata.booterp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.playdata.booterp.board.BoardService;
import com.playdata.booterp.dto.BoardDTO;

@Controller
@RequestMapping("/json")
public class JSONTestController {

	BoardService service;

	@Autowired
	public JSONTestController(BoardService service) {
		super();
		this.service = service;
	}
	
	@ResponseBody
	@GetMapping("/getJsonObj")
	public BoardDTO responseObj() {
		return service.getBoardInfo("73");
	}

	@ResponseBody
	@GetMapping("/getJsonArr")
	public List<BoardDTO> responseJsonArr() {
		return service.boardList();
	}

}
