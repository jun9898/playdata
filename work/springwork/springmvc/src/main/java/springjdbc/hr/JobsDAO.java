package springjdbc.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JobsDAO implements AbstractJobsDAO{
	
//	DB에 SQL을 실행할 수 있도록 기능을 지원하는 Spring JDBC의 클래스
	JdbcTemplate template;
	
	public JobsDAO() {
	}

	@Autowired
	public JobsDAO(JdbcTemplate template) {
		super();
		this.template = template;
	}

	public void getCount() {
		int result = template.queryForObject("select count(*) from jobs", Integer.class);
		System.out.println("조회된 데이터의 값 : " + result);
	}

}
