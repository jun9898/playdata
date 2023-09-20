package springjdbc.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsService implements AbstractJobsService{
	
	AbstractJobsDAO dao;
	
	public JobsService() {
	}


	@Autowired
	public JobsService(AbstractJobsDAO dao) {
		super();
		this.dao = dao;
	}

	public void getCount() {
		dao.getCount();
	}

}
