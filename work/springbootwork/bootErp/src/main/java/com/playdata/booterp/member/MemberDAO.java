package com.playdata.booterp.member;



import java.util.List;

import com.playdata.booterp.dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> getTreeEmpList(String deptno);
	int insert(MemberDTO user);
	List<MemberDTO> getMemberList();
	int delete(String id);
	MemberDTO read(String id);
	List<MemberDTO> search(String column, String search,String pass);
	int update(MemberDTO user);
	MemberDTO login(MemberDTO loginUser);
	boolean idCheck(String id);
	MemberDTO findById(String id);
}














