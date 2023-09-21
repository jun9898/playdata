package com.playdata.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// JdbcTemplate의 기능을 이용해서 DB 액세스
@Repository
public class DeptDAOImpl implements DeptDAO{

	JdbcTemplate template;
	
	public DeptDAOImpl() {
	}

	@Autowired
	public DeptDAOImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<DeptDTO> getDeptName() {
		return null;
	}

	@Override
	public int insert(DeptDTO dept) {
		String sql = "insert into dept values(?,?,sysdate,null,?,?,?,?,?,?,?)";
		// update(sql문, ?에 매핑될 값들을 나열)
		return template.update(sql, dept.getDeptno(),dept.getDeptname(),dept.getDeptlevel(),
				dept.getDeptstep(),dept.getDeptuppercode(),dept.getJob_category(),
				dept.getMgr_id(),dept.getDeptaddr(),dept.getDepttel());
	}

	@Override
	public List<DeptDTO> select() {
		// 조회한 ResultSet의 레코드를 어떤 dto에 매핑할 것인지 정보를 담고 있는 RowMapper 객체와 SQL문을 메소드 호출하면서 전달
		return template.query("select * from dept", new DeptRowMapper());
	}

	@Override
	public int delete(String deptno) {
		return template.update("delete from dept where deptno=?" ,new Object[] {deptno});
	}

	@Override
	public DeptDTO read(String deptno) {
		return template.queryForObject("select * from dept where deptno=?" ,new Object[] {deptno}, new DeptRowMapper());
	}

	@Override
	public int update(DeptDTO dept) {
		String sql="update dept set mgr_id=?, deptaddr=?, depttel=? where deptno=?";
		return template.update(sql, dept.getMgr_id(), dept.getDeptaddr(), dept.getDepttel(), dept.getDeptno());
			
	}

}
