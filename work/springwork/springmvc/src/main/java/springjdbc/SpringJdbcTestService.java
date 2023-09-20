package springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringJdbcTestService {

	@Autowired
	SpringJdbcTestDAO dao;
	public void getEmpCount() {
		dao.count();
	}
	
}
