package app3;

public class MyBeanStyleB implements MyBean {

	public MyBeanStyleB() {
		System.out.println("============MyBeanStyleB 생성===========");
	}
	@Override
	public void testHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("hello! " + name);
	}

}
