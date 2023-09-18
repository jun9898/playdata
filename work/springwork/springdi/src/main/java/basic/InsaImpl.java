package basic;
public class InsaImpl implements Insa {
	MemberDAO dao;
	
	public InsaImpl() {
		System.out.println("InsaImpl 기본생성자");
	}
	
	@Override
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;

	}
	
	public InsaImpl(MemberDAO dao) {
		this.dao = dao;
		System.out.println("InsaImpl 매개변수 1개 생성자");
	}

	@Override
	public void addUser(MemberDTO user) {
		dao.add(user);
	}

	@Override
	public MemberDTO getUser(String id) {
		dao.getUser("id");
		return null;
	}

}
