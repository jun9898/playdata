package annotation.exam01;

import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements Logic {

	public LogicImpl() {
		System.out.println("Logic Impl constructor");
	}
	
	@Override
	public void testLogic() {
		// TODO Auto-generated method stub
		System.out.println("db���� xml json ������� �����ϴ� �����Ͻ� �޼ҵ�");

	}

}
