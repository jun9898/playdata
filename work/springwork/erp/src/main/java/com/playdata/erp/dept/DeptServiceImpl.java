package com.playdata.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// DeptDAO의 메소드를 호출
// -> 비지니스 로직
// -> 트랜잭션 처리
// -> 컨트롤러에서 받은 데이터를 가공해서 DAO로 넘기거나 받은 데이터를 가공해서 컨트롤러에 넘기기
@Service
public class DeptServiceImpl implements DeptService {
	
	DeptDAO dao;
	
	public DeptServiceImpl() {
		super();
	}

	@Autowired
	public DeptServiceImpl(DeptDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(DeptDTO dept) {
		return dao.insert(dept);
	}

	@Override
	public List<DeptDTO> getDeptName() {
		return null;
	}

	@Override
	public List<DeptDTO> select() {
		return dao.select();
	}

	@Override
	public int delete(String deptno) {
		return dao.delete(deptno);
	}

	@Override
	public DeptDTO read(String deptno) {
		return dao.read(deptno);
	}

	@Override
	public int update(DeptDTO dept) {
		return dao.update(dept);
	}

}
