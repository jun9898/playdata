package oop.polymorphism;
/*
 * 추상클래스
 * => 상위클래스의 역할을 하는 클래스
 * => 객체를 생성할 수 없는 클래스(미완성된 클래스)
 * => 내용이 구현되어 있지 않은 메소드를 포함하고 있는 클래스를 추상 클래스라 한다.
 * 	  -----------------------
 * 	  	추상 메소드(body가 없는 메소드)
 * 1) 추상 메소드를 선언하는 방법
 * 	  접근제어자 abstract 리턴타입 메소드명 (매개변수1, 매개변수2....);
 * 2) 추상클래스의 특징
 * 	  - 추상메소드가 하나라도 정의되어 있으면 추상클래스가 된다. 추상클래스는 선언부에 abstract을 추가한다.
 *    - 추상 클래스에는 추상 메소드와 일반 메소드를 모두 정의할 수 있다.
 *    - 추상 클래스는 객체생성을 할 수 없는 클래스
 *    - 추상 클래스를 상속받는 클래스는 extends하면 에러가 발생
 *    => Child 클래스가 Parent를 상속받는다.
 *    	 Parent클래스의 모든 멤버(메소드, 필드)가 Child의 소유가 된다.
 *    	 Child 클래스는 Parent클래스의 일반 메소드인 test 메소드와 추상메소드인 display를 소유하므로 Child 클래스도
 *    	 추상 클래스가 된다.
 *    [ 에러처리 ]
 *    1. Child 클래스에 abstract을 추가한다.
 *    2. Child가 상소고받은 추상메소드를 재정의한다. (오버라이딩)
 *    
 *    - abstract 클래스는 상위 클래스로 사용하기 위해서 정의(상위클래스로 사용할 목적으로 정의되며 실제 타입으로 선언되어 사용)
 *    - abstract 메소드는 하위 클래스에서 반드시 오버라이딩 되어야 한다는 것을 문법적으로 제시
 */

abstract class Parent{

//	추상 메소드는 추상 클래스에서만 선언할 수 있으며 추상 클래스에는 일반 메소드를 선언할 수 있다.
	public void test() {
		System.out.println("test - 일반메소드");
	}

	// 추상메소드
	public abstract void display(String msg);
}

class Child extends Parent {

	@Override
	public void display(String msg) {
		System.out.println(msg);
	}
	
	
}

public class AbstractTest {
	public static void main(String[] args) {

//		추상 클래스는 직접적으로 객체를 생성할 수 없음.
//		Parent obj = new Parent();

		Parent obj = new Child();
		
		obj.display("test");

	}

}
