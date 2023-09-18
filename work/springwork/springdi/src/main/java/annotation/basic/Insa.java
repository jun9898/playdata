package annotation.basic;
public interface Insa {
	void addUser(MemberDTO user);
	MemberDTO getUser(String id);
	void setDAO(DAO dao);
}

