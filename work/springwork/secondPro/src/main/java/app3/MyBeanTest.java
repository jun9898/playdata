package app3;
/*
 *	OOP 특성을 적용해서 변경
 *	=> 객체를 변경하면 기존의 메소드를 변경하지 않아도 동작한다.
 *	=> 그러나 객체를 사용하기 위해 만든 코드는 변경해야 한다. 
 */
public class MyBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBean obj = new MyBeanStyleB();
		run(obj);
		show(obj);
		change(obj);
	}
	public static void run(MyBean obj) {
		System.out.println("================");
		obj.testHello("jbj");
		System.out.println("================");
	}
	public static void show(MyBean obj) {
		obj.testHello("jbj");
		obj.testHello("jbj");
		obj.testHello("jbj");
	}
	public static void change(MyBean obj) {
		System.out.println("*****************");
		obj.testHello("jbj");
		System.out.println("*****************");
		
	}
}
