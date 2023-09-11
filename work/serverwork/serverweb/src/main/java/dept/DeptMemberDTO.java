package dept;

import java.sql.Date;

//Data Transfer Object
//=> 테이블 레코드 하나를 객체로 표현해 놓음
//=> 비지니스로직을 담고 있지 않고 순수하게 값을 표현해 놓은 객체
//=> 계층간의 데이터를 교환하기 위해서 생성
//=> 사용자가 입력한 데이터를 담아서 서버로 전송
//=> 서버에서 발생한 데이터를 담아서 뷰로 전송
public class DeptMemberDTO {
	//멤버변수로 테이블의 컬럼을 정의
	private String deptno;
	private String deptname;
	private String tel;
	private String addr;
	public DeptMemberDTO() {

	}

	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	// update용
	public DeptMemberDTO(String deptno, String deptname, String tel, String addr) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
		this.tel = tel;
		this.addr = addr;
	}

//	delete용
	public DeptMemberDTO(String deptno) {
		super();
		this.deptno = deptno;
	}
}

	
	
	
	

	
	
	
	//insert용

