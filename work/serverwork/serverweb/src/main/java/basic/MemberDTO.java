package basic;

import java.sql.Date;

//Data Transfer Object
//=> 테이블 레코드 하나를 객체로 표현해 놓음
//=> 비지니스로직을 담고 있지 않고 순수하게 값을 표현해 놓은 객체
//=> 계층간의 데이터를 교환하기 위해서 생성
//=> 사용자가 입력한 데이터를 담아서 서버로 전송
//=> 서버에서 발생한 데이터를 담아서 뷰로 전송
public class MemberDTO {
	//멤버변수로 테이블의 컬럼을 정의
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Date regdate;
	private int point;
	private String info;
	public MemberDTO() {
		
	}
	//insert용
	public MemberDTO(String id, String pass, String name, String addr, String info) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.info = info;
	}
	//select용
	public MemberDTO(String id, String pass, String name, String addr, Date regdate, int point, String info) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.regdate = regdate;
		this.point = point;
		this.info = info;
	}
	

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", regdate=" + regdate
				+ ", point=" + point + ", info=" + info + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}













