package com.playdata.erp.dept;

import java.util.List;

public interface DeptService {
	int insert(DeptDTO dept);
	List<DeptDTO> getDeptName();
	public List<DeptDTO> select();
	public int delete(String deptno);
	public DeptDTO read(String deptno);
	int update(DeptDTO dept);
}
