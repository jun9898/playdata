package basic;
public class MemberDAO implements DAO{
	
	public MemberDAO() {
		System.out.println("MemberDAO �⺻������");
	}
	public void add(MemberDTO user){
		System.out.println("ȸ������");
	}
	public MemberDTO getUser(String id){
		System.out.println("���̵�� ȸ�� ��ȸ�ϱ�");
		return null;
	}
}