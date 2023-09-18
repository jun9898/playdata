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
		System.out.println("db연동 xml json 연산등을 수행하는 비지니스 메소드");

	}

}
