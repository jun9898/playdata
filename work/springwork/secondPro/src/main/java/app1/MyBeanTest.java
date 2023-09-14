package app1;
/*
 * 결합도가 극도로 높은 프로그램
 * => 클래스 결합도가 높고 의존성이 높다. 사용하는 클래스가 변경되면 이 클래스를 이용해서 작업하는 모든 기능의 클래스와 메소드가 
 * 	  전부 수정되어야 한다.
 * => oop 특성이 적용되지 않았다.
 * => 상위 인터페이스와 구현체(상위 인터페이스를 상속해서 실제 코드가 구현된 클래스)를 분리하지 않았다.
 * 	  ---------------------------
 * 		다형성이 적용되지 않음
 * 
 */
public class MyBeanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBeanStyleA obj = new MyBeanStyleA();
		run(obj);
		show(obj);
		change(obj);
	}
	public static void run(MyBeanStyleA obj) {
		System.out.println("================");
		obj.testHello("jbj");
		System.out.println("================");
	}
	public static void show(MyBeanStyleA obj) {
		obj.testHello("jbj");
		obj.testHello("jbj");
		obj.testHello("jbj");
		
	}
	public static void change(MyBeanStyleA obj) {
		System.out.println("*****************");
		obj.testHello("jbj");
		System.out.println("*****************");
		
	}
}
