package com.playdata.erp.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.playdata.erp.dept.DeptDTO;
import com.playdata.erp.dept.DeptService;

@Controller
@RequestMapping("/emp")
//@SessionAttribute("user") 는 user라는 것은 세션에 저장하는 어트리뷰트 명
// 컨트롤러에서 user라는 이름으로 Model 객체에 저장된 어트리뷰트가 있으면 
//@SessionAttributes를 이용해서 세션을 사용하는 경우 컨트롤러에 @SessionAttributes("user")가 있어야 사용할 수 있다.
//												  ---------------------------
//												  model에서 값을 저장하고 가져와도 세션에 있는 값으로 등록되므로 사용이 가능
//												  만약 다른 컨트롤러에서 사용하는 경우 컨트롤러 상단에
//												  SessionAttribute("user")를 선언하고 사용해야 한다.
@SessionAttributes("user")
public class MemberController {
	
	MemberService service;
	DeptService deptService;

	@Autowired
	public MemberController(MemberService service, DeptService deptService) {
		super();
		this.service = service;
		this.deptService = deptService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(MemberDTO loginUser, HttpServletRequest request) {
		MemberDTO user = service.login(loginUser);
		String view ="";
		if (user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			view = user.getMenupath();
		} else {
			view="redirect:/emp/login";
		}
		return view; // 로그인한 사용자의 job을 검사해서 job에 해당하는 메뉴가 보일 수 있도록 뷰를 연결
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if (session != null) {
			// 사용하던 세션을 메모리에서 제거하기
			session.invalidate();
		}
		return "redirect:/emp/login";
	}
	
	// 스프링에서 제공되는 기능을 이용한 로그인
	@PostMapping("/spring/login")
	public String springlogin(MemberDTO loginUser, Model model) {
		System.out.println("스프링이 제공하는 @sessionAttribute를 이용해서 세션을 처리하기");
		MemberDTO user = service.login(loginUser);
		String view ="";
		if (user!=null) {
			model.addAttribute("user", user);
			view = user.getMenupath();
		} else {
			view="redirect:/emp/login";
		}
		return view; 
	}
	
	// @SessionAttributes를 이용해서 로그인 처리를 한 경우 SessionStatus객체의 메소드를 이용해서 처리한다.
	// 세션에 저장된 객체를 제거하기 위한 객체
	@GetMapping("/spring/logout")
	public String springlogout(SessionStatus status) {
		System.out.println("SessionStatus를 이용한 로그아웃 처리");
		status.setComplete(); // 세션에 저장된 객체를 제거
		return "redirect:/index.do";
		
	}
	
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		// 나중에는 제일 복잡한 컨트롤러가 될 수 있다.
		// 결재에 대한 진행상황
		// 스케쥴표 - 업무스케쥴, 미팅일정, 휴가일정
		// 진행중인 메인 업무를 할 수 있는 뷰를 추가
		MemberDTO user = (MemberDTO)session.getAttribute("user");
		return user.getMenupath();
	}
	
	@GetMapping("/insert")
	public String insertPage(Model model) {
		List<DeptDTO> deptlist = deptService.select();
		model.addAttribute("deptlist", deptlist);
		return "member/insertPage";
	}

	@PostMapping("/insert")
	public String insertMember(MemberDTO member, HttpSession session) {
		service.insert(member);
		return "member/insertPage";
	}

}
