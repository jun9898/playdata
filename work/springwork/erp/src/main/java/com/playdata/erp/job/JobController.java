package com.playdata.erp.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {
	
	JobService service;

	@Autowired
	public JobController(JobService service) {
		super();
		this.service = service;
	}

	@GetMapping("/job/register")
	public String register() {
		return "job/register";
	}

	@PostMapping("/job/register")
	public String insert(JobDTO job) {
		service.insert(job);
		return "job/register";
	}

	@GetMapping("/job/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("job/list");
		List<JobDTO> dept = service.select();
		mav.addObject("deptlist", dept);
		return mav;
	}

	@GetMapping("/job/read")
	public ModelAndView read(String job_id) {
		ModelAndView mav = new ModelAndView("job/read");
		JobDTO dept = service.read(job_id);
		mav.addObject("dept", dept);
		return mav;
	}

	@GetMapping("/job/update")
	public ModelAndView updateView(String job_id) {
		ModelAndView mav = new ModelAndView("job/updateView");
		mav.addObject("job_id",job_id);
		return mav;
	}

	@PostMapping("/job/update")
	public String update(JobDTO job) {
		service.update(job);
		return "redirect:/job/list";
	}

	@GetMapping("/job/delete")
	public String delete(String job_id) {
		service.delete(job_id);
		return "redirect:/job/list";
	}
}
