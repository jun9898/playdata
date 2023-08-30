package oop.inheritance;
/*
 * [[ 상속관계에서 멤버변수가 갖는 특징 ]]
 * 1. 상속관계에서 상위클래스에 선언된 멤버변수는 하위클래스에서 접근이 가능하다.
 * 2. 상위클래스에서 선언된 변수와 동일한 이름의 멤버변수를 하위 클래스에서 정의하면 하위클래스 내부에서는 부모클래스의 멤버 변수보다
 * 	  하위클래스의 멤버변수가 우선순위가 높다.
 * 	  (외부에서 사용되는 경우는 선언된 참조변수의 타입이 뭐냐에 따라 달라진다.)
 * 3. 하위클래스 내부에서 상위클래스의 멤버를 접근하고 싶다면 super키워드를 이용해서 접근한다.
 * 	  this -> 자기 자신의 객체
 * 	  super -> 부모의 객체
 * 4. 상위클래스의 멤버가 private으로 정의되어 있으면 하위클래스에서 접근할 수 없다.
 */

class Super{
	int num = 10;
}

class Sub extends Super{
	// 필드의 재정의 
	int num = 100;
	public void display() {
		System.out.println("num => " + num);
		System.out.println("부모의 num => " + super.num);
	}
}

public class InheritanceTest1 {
	public static void main(String[] args) {
		Sub obj = new Sub();
		obj.display();
		System.out.println("obj의 num =>" + obj.num);
		
	}

}
