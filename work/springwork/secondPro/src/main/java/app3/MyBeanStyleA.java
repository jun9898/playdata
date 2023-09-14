package app3;


public class MyBeanStyleA implements MyBean{

	public MyBeanStyleA() {
		System.out.println("====================MyBeanStyle 객체 생성==============");
	}
	
	
	@Override
	public void testHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 " + name + "님!");
	}

	
}
