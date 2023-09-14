package basic;
public class TestMain {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
//		Insa insa = new InsaImpl(dao);
		Insa insa = new InsaImpl();
		insa.setMemberDAO(dao);
		MemberDTO user = new MemberDTO("jang","1234","전병준");
		insa.addUser(user);
	}
}