package com.playdata.booterp.board;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.playdata.booterp.dto.BoardDTO;
import com.playdata.booterp.dto.BoardFileDTO;

@Controller
public class BoardController {

	BoardService service;
	FileUploadLogicService fileuploadservice;


	@Autowired
	public BoardController(BoardService service, FileUploadLogicService uploadFile) {
		super();
		this.service = service;
		this.fileuploadservice = uploadFile;
	}

	@GetMapping("/board/list")
	public String list(Model model, String category) {
		List<BoardDTO> boardlist = service.findByCategory(category);
		model.addAttribute("boardlist",boardlist);
		model.addAttribute("category", category);
		return "board/boardlist";
	}
	
	@GetMapping("/board/write")
	public String writePage(Model model) {
		return "board/board_write";
	}

	@PostMapping("/board/write")
	public String write(BoardDTO board, HttpSession session) throws IllegalStateException, IOException {
//		1. MultipartFile 정보 추출
		List<MultipartFile> files = board.getFiles();

//		2. 업로드될 서버의 경로 추출 (업로드될 위치)
//		=> 실제 서버의 경로를 추출하기 위해서 Context객체의 정보를 담고 있는 ServletContext 객체를 추출
//		=> ServletContext가 웹에서 운영하는 사이트(프로젝트)에 대한 정보를 담고 있는 객체이고
//		   실제 경로를 구할 수 있는 메소드가 있다.
//		   스프링 내부에서 처리할 수 있도록 서블릿 컨텍스트 객체를 만들어서 전달
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");

//		3. 업로드 되도록 처리 - 업로드로직을 구현해서 실제 서버가 인식하는 위치에 업로드가 되도록 처리.
		List<BoardFileDTO> boardfiledtolist = fileuploadservice.uploadFiles(files, path);
		
//		4. 게시글에 대한 일반적인 내용과 첨부파일이 있는 경우 첨부파일의 정보를 담은 List를 디비에 저장할 수 있도록 넘기기

		service.insert(board,boardfiledtolist);
		return "redirect:/board/list?category=all";
	}

	@GetMapping("/board/read")
	public ModelAndView read(String board_no, String cmd) {
		BoardDTO board = service.getBoardInfo(board_no);
		List<BoardFileDTO> boardfiledtolist = service.getFileList(board_no);
		String view="";
		if (cmd.equals("view")) {
			view = "board/board_read";
			System.out.println(view);
		} else {
			view = "board/board_update";
		}
		ModelAndView mav = new ModelAndView(view);
		mav.addObject("board",service.getBoardInfo(board_no));
		mav.addObject("boardfiledtolist",boardfiledtolist);
		System.out.println(board_no);
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
		return "board/listview";
	}

}
