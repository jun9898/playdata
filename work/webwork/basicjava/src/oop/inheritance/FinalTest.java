package oop.inheritance;

/*
 * final
 * 변수 -> 상수로 정의
 * 메소드 -> 오버라이딩 할 수 없는 메소드
 * 클래스 -> 상속할 수 없는 클래스
 */
final class A {
	public void test() {
		
	}

	public final void login(String pass) {
		System.out.println("부모클래스의 중요한 메소드 - 인증하고 엑세스하기");
	}

}

//class B extends A {
//	public void login(String pass) {
//		System.out.println("인증하지 않고 엑세스 하는 코드로 수정하기");
//	}
//}

public class FinalTest {
	static final int CODE = 100;
	public static void test() {
		
		// CODE = 200; 상수는 값을 재할당할 수 없다.
	}
	public static void main(String[] args) {
//		B obj = new B();
//		obj.login("");
		
	}

}
