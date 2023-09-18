package annotation.basic;

import org.springframework.stereotype.Component;

@Component("customerdao")
public class CustomerDAO implements DAO{
	
	public CustomerDAO() {
		System.out.println("CustomerDAO 기본생성자");
	}

	public void add(MemberDTO user){
		System.out.println("CustomerDAO 회원가입");
	}

	public MemberDTO getUser(String id){
		System.out.println("아이디로 회원 조회하기");
		return null;
	}
}