package basic;
public class InsaImpl implements Insa {
	MemberDAO dao;
	
	public InsaImpl() {
		System.out.println("InsaImpl �⺻������");
	}
	
	@Override
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;

	}
	
	public InsaImpl(MemberDAO dao) {
		this.dao = dao;
		System.out.println("InsaImpl �Ű����� 1�� ������");
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
