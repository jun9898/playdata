package springjdbc.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobsController {
	
	AbstractJobsService service;
	 
	public JobsController() {
	}

	@Autowired
	public JobsController(AbstractJobsService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/springjdbc/getJobs")
	public String getCount() {
		service.getCount();
		return "main/index";
		 
	 }

}
