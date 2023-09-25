package com.playdata.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	BoardService service;

	@Autowired
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/board/list")
	public String list(Model model, String category) {
		System.out.println(category);
		List<BoardDTO> boardlist = service.findByCategory(category);
		model.addAttribute("boardlist",boardlist);
		model.addAttribute("category", category);
		return "board/listview";
	}
	
	@GetMapping("/board/write")
	public String writePage(Model model) {
		return "board/writepage";
	}

	@PostMapping("/board/write")
	public String write(BoardDTO board) {
		service.insert(board);
		return "redirect:/board/list?category=all";
	}

	@GetMapping("/board/read")
	public ModelAndView read(String board_no, String cmd) {
		String view="";
		if (cmd.equals("view")) {
			view = "board/read";
		} else {
			view = "board/update";
		}
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("board",service.getBoardInfo(board_no));
		return mav;
	}

	@PostMapping("/board/update")
	public String read(BoardDTO board) {
		service.update(board);
		return "redirect:/board/list?category=all";
	}

	@GetMapping("/board/delete")
	public String delete(String board_no) {
		service.delete(board_no);
		return "redirect:/board/list?category=all";
	}

	@PostMapping("/board/search")
	public String search(Model model, String search, String tag) {
		List<BoardDTO> boardlist = service.search(tag, search);
		model.addAttribute("boardlist",boardlist);
		System.out.println(boardlist);
		return "board/listview";
	}

}
