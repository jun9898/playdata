package springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 스프링이 제공하는 기능을 이용해서 DB연동하는 클래스
@Repository
public class SpringJdbcTestDAO {

	@Autowired
	JdbcTemplate template;
	public void count() {
		// emp테이블의 갯수를 출력하는 메소드
		System.out.println(template.queryForObject("select count(*) from emp", Integer.class));
		
	}

}
