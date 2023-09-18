package di.setter01;

public class MyServiceImpl implements MyService {

	String name;
	String msg;
	Logic logic;
	
	public MyServiceImpl() {
	}
	
	

	public void setName(String name) {
		this.name = name;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public void setLogic(Logic logic) {
		this.logic = logic;
	}



	@Override
	public void testService() {
		// TODO Auto-generated method stub
		System.out.println(msg + " ," + name);
		logic.testLogic();
	}

}
