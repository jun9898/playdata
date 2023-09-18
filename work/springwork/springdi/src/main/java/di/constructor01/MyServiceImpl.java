package di.constructor01;

public class MyServiceImpl implements MyService {

	String name;
	String msg;
	Logic logic;
	
	public MyServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("MyserviceImpl 기본생성자");
	}

	public MyServiceImpl(String name, String msg, Logic logic) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
		System.out.println("MyserviceImpl 매개변수 3개 생성자");
	}

	public MyServiceImpl(Logic logic, String name, String msg ) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
		System.out.println("MyserviceImpl 매개변수 3개 생성자------bean 중복 test");
	}



	@Override
	public void testService() {
		// TODO Auto-generated method stub
		System.out.println(msg + " ," + name);
		logic.testLogic();

	}

}
