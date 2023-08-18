package oop.polymorphism;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

// 객체의 형변환
// 참조형에서의 형변환은 상속관계에서만 성립한다.
class Super{
	
	String data = "상위 data";

	public void display() {
		System.out.println("상위 클래스의 display");
	}
	
}

class Sub extends Super{
	
	String data = "하위 data";

	public void display() {
		System.out.println("하위 클래스의 display");
	}
	public void test() {
		System.out.println("하위 클래스의 test");
	}
	
}
public class RefTypeCastingTest1 {
	public static void main(String[] args) {
		
//		AbstractCollection c1 = new Vector();
//		AbstractList c2 = new Vector();
//		AbstractList c3 = new Stack();
//		Vector c4 = new Stack();
		
//		상속관계에 속해있지 않아 에러가 발생한다.
//		ArrayList c5 = new Vector();
		
		System.out.println("1. Super 타입의 참조 변수로 Super 객체를 사용.");
		Super obj = new Super();
		obj.display();
		System.out.println(obj.data);
		
		System.out.println("-------------------------------");

		System.out.println("2. Sub 타입의 참조 변수로 Sub 객체를 사용.");
		Sub obj2 = new Sub();
		obj2.display(); // 오버라이딩된 메소드가 우선으로 호출된다.
		System.out.println(obj2.data); // obj2 변수가 어떤 타입이냐에 따라서 해당 타입이 갖고 있는 변수값을 가져온다.
									   // 상속관계에서 동일한 타입의 변수가 있는 경우 상위타입보다는 나의 변수가 우선 인식

		System.out.println("-------------------------------");

		System.out.println("3. Super 타입의 참조 변수로 Sub 객체를 사용.");
//		자동 형변환
//		obj3 참조변수가 Super 타입이므로 Super의 멤버만 접근할 수 있다.
//		단, Sub객체를 참조하므로 오버라이딩된 메소드가 있는 경우 오버라이딩된 메소드가 먼저 실행
//		new Sub가 가능한 이유는 Sub객체가 참조변수 타입인 Super 정보를 가지고 있으므로 가능
		Super obj3 = new Sub();
		obj3.display();
		System.out.println(obj3.data);
		// obj3이 Super 타입이르모 Super의 멤버만 사용 가능하지만 참조하는 객체가 Sub 타입이므로 명시적 형변환이 가능
		((Sub)obj3).test();
		System.out.println(((Sub)obj3).data);
		
		System.out.println("-------------------------------");

		System.out.println("4. Sub 타입의 참조 변수로 Super 객체를 사용.");
//		실제 사용되는 변수의 타입에 대한 정보가 생성되는 객체에 없기 때문에 사용할 수 없다.
//		Sub obj4 = new Super(); -------- 에러 발생

		System.out.println("-------------------------------");
		
		System.out.println("5. Sub 변수 = Super 객체를 참조하는  변수.");
//		명시적으로 캐스팅을 하면 컴파일러는 속일 수 있으나(상속관계에 있어야만 속는다.)
//		obj1이 참조하는 객체가 Super이므로 실행할때 캐스팅 오류가 발생한다.
//		Sub obj5 = (Sub)obj;;

		System.out.println("-------------------------------");

		System.out.println("6. Sub 변수 = Super 객체를 참조하는  변수.");
//		obj3은 Super타입이므로 자동캐스팅은 불가능
//		명시적으로 캐스팅하면 가능 - obj1과 다르게 실제 참조하는 객체가 Sub타입이므로 참조변수의 모든 정보를 갖고 있으므로 가능	
		Sub obj6 = (Sub)obj3;;
	}

}
