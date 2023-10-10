package com.playdata.booterp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playdata.booterp.board.BoardService;
import com.playdata.booterp.dto.BoardDTO;

@RestController
public class BoardJSONController {

	BoardService service;

	@Autowired
	public BoardJSONController(BoardService service) {
		this.service = service;
	}

	@GetMapping(value="/categorySearch")
	public List<BoardDTO> responseJsonArr(String category) {
		return service.findByCategory(category);
	}
}
