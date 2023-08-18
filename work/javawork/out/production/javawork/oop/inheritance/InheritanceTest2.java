package oop.inheritance;

/*
 * [[ 상속관계에서 메소드가 갖는 특징 ]]
 * 1. 상위클래스에서 정의된 메소드를 하위클래스에서 호출할 수 있다.
 * 	  => 하위클래스 타입의 참조변수를 통해서도 상위클래스의 메소드를 사용할 수 있다.
 * 2. 상위 클래스에 정의된 메소드와 동일한 메소드를 하위클래스에 정의하면 하위클래스의 메소드가 우선으로 인식된다.
 *    => 상위클래스에 정의된 메소드의 시그니쳐(리턴타입, 메소드면, 매개변수갯수, 매개변수 타입)가 동일한 경우 이를
 *    	 메소드 재정의라고 한다. 즉 메소드 오버라이딩이라 한다.
 * 3. 상위클래스의 메소드를 호출하려면 super를 이용해서 호출
 * 
 */
class Parent{
	public void display() {
		System.out.println("부모의 display");
	}
}

// 메소드 오버라이딩
class Child extends Parent{
	public void test() {
		System.out.println("자식클래스의 test");
	}

	public void display() {
		System.out.println("자식의 display()");
		super.display(); // 부모의 display
	}

}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Child obj = new Child();
		obj.display();
		obj.test();
	}
}
