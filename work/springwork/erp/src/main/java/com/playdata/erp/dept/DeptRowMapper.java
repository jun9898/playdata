package com.playdata.erp.dept;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

// 레코드 하나가 메소드 한 번 호출 - mapRow
// while문이나 if문 안에서 객체와 매핑하는 코드를 구현
// query, queryForObject 메소드 내부에서 DB에서 조회한 레코드를 어떤 객체로 매핑하는지 정보를 담고 있는 객체
public class DeptRowMapper implements RowMapper<DeptDTO>{

	@Override
	public DeptDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("mapRow ===> " + rowNum);
		DeptDTO dept = new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
				, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)
				, rs.getString(10), rs.getString(11));
		// TODO Auto-generated method stub
		System.out.println(dept);
		return dept;
	}

}
