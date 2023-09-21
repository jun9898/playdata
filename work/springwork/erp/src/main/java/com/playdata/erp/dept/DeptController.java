package com.playdata.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeptController {
	
	DeptService service;

	@Autowired
	public DeptController(DeptService service) {
		super();
		this.service = service;
	}
	
	// insert를 하기 위해서 view를 볼 수 있는 메소드
	@GetMapping("/dept/register")
	public String showPage() {
		return "dept/dept_register";
		
	}
	
	//view에 입력한 데이터를 db에 insert하기위한 메소드
	@PostMapping("/dept/register")
	public String insert(DeptDTO dept) {
		System.out.println(dept);
		service.insert(dept);
		// 기본이 forward, 리다이렉트를 하고 싶은 경우 뷰(tiles에 등록한 뷰이름, 컨트롤러 요청 path)
		return "redirect:/index.do";
		
	}
	
	//DBMS에서 저장된 데이터를 조회하기 위한 메소드
	@GetMapping("/dept/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("dept/list");
		List<DeptDTO> list =service.select();
		System.out.println(list);
		mav.addObject("deptlist", list);
		return mav;
	}

	@GetMapping("/dept/getdept")
	public ModelAndView read(String deptno, String cmd) {
		String path ="";
		if (cmd.equals("view")) {
			path = "dept/read";
		} else {
			path = "dept/update";
		}
		ModelAndView mav = new ModelAndView(path);
		
		DeptDTO dept =service.read(deptno);
		mav.addObject("dept", dept);
		return mav;
	}

	@GetMapping("/dept/delete")
	public String delete(String deptno) {
		int dept =service.delete(deptno);
		return "redirect:/dept/list";
	}

	@PostMapping("/dept/update")
	public String update(DeptDTO dept) {
		service.update(dept);
		return "redirect:/dept/list";
	}
	
	
}
