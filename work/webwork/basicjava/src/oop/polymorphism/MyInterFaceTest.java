package oop.polymorphism;

/*
 * [[ 인터페이스 ]]
 * => 추상메소드만 보관하는 특별한 클래스
 * 	  인터페이스를 사용하면 다형성을 적용할 수 있고 다중상속을 구현할 수 있다.
 * 	  인터페이스는 상위타입으로 사용되는 특별한 클래스
 * 	  
 * 	  1. 인터페이스를 정의하는 방법은 interface 키워드를 이용해서 정의
 * 	  2. 인터페이스는 추상 메소드만 정의하는 특별한 클래스이므로
 * 		 - 인터페이스에 정의하는 메소드는 public과 abstract 은 생략이 가능(abstract을 추가하지 않아도 추상 메소드로 인식)
 * 		 - 하위 클래스에서 오버라이딩 될때 자동으로 public이 추가되고
 * 		 - 나머지 리턴타입이나 매개변수는 일반 메소드와 동일
 * 
 * 	  3. 클래스가 인터페이스를 상속하는 경우 implements 키워드를 이용해서 구현
 * 	  4. 인터페이스가 인터페이스를 상속하는 경우 extends 키워드를 이용해서 구현
 * 		 - 인터페이스끼리 상속하는 경우 다중 상속이 가능
 * 		 - ,를 이용해서 상속할 인터페이스를 정의
 * 	  5. 클래스가 인터페이스를 상속하는 경우 다중상속이 가능하다. 
 * 		 - ,로 구분한다.
 * 	  6. 클래스가 인터페이스와 클래스를 모두 상속하는 경우 클래스상속이 인터페이스 상속보다 먼저 정의되어야 한다.
 * 		 Class A extends Super implement InterA {
 * 				 -------
 * 				 implements보다 먼저 정의되어야 한다.
 * 		 } 
 */
interface SuperInterfaceA {
	void show(); // public abstract void show() 로 정의한것으로 인식
	int test(String name);
}

interface InterA{
	void test();
}

interface InterB{
	void change();
}

interface ChildInter extends InterA, InterB{

}


class MyClass implements SuperInterfaceA{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int test(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

public class MyInterFaceTest {
	public static void main(String[] args) {
		
	}
	

}
