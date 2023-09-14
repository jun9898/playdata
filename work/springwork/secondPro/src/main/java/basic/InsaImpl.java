package basic;
public class InsaImpl implements Insa {
	MemberDAO dao;
	
	@Override
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}

	public InsaImpl() {
	}
	
	public InsaImpl(MemberDAO dao) {
		this.dao = dao;
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
