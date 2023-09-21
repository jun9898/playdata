package com.playdata.erp.dept;

import java.util.List;


public interface DeptDAO {
	List<DeptDTO> getDeptName();
	int insert(DeptDTO dept);
	public List<DeptDTO> select();
	public int delete(String deptno);
	public DeptDTO read(String deptno);
	int update(DeptDTO dept);
}
