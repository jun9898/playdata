package annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("insa")
public class InsaImpl implements Insa {

	@Autowired
	@Qualifier("customerdao")
	DAO dao;
	
	// ��������� ���� injection
	public InsaImpl() {
		System.out.println("InsaImpl �⺻������");
	}

	public InsaImpl(DAO dao) {
		this.dao = dao;
		System.out.println("InsaImpl �Ű����� 1�� ������");
	}
	
	@Override
	public void setDAO(DAO dao) {
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
