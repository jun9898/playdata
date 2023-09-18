package annotation.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("service")
public class MyServiceImpl implements MyService {

	@Value("nameTest")
	String name;
	@Value("msgTest")
	String msg;
	@Autowired
	Logic logic;
	
	public MyServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("MyserviceImpl �⺻������");
	}

	public MyServiceImpl(String name, String msg, Logic logic) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
		System.out.println("MyserviceImpl �Ű����� 3�� ������");
	}

	public MyServiceImpl(Logic logic, String name, String msg ) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
		System.out.println("MyserviceImpl �Ű����� 3�� ������------bean �ߺ� test");
	}



	@Override
	public void testService() {
		// TODO Auto-generated method stub
		System.out.println(msg + " ," + name);
		logic.testLogic();

	}

}
