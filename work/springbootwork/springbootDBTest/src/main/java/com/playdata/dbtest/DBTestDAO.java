package com.playdata.dbtest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DBTestDAO {

	@Autowired
	JdbcTemplate template;
	@Autowired
	SqlSession sqlSessionTemplate;

	public int jdbcTemplateTest() {
		return template.queryForObject("select count(deptno) from dept", Integer.class);
	}

	public List<DeptDTO> select() {
		return sqlSessionTemplate.selectList("com.playdata.dbtest.test");
	}

}
