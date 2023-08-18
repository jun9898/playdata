package oop.basic;

// StaticMethodDemo를 테스트할 수 있는 클레스
public class StaticMethodDemoTest {
	public static void main(String[] args) {
		StaticMethodDemo obj = new StaticMethodDemo();
		System.out.println(StaticMethodDemo.staticNum);
		System.out.println("====================");

		// static 블럭은 한번만 실행된다.
		StaticMethodDemo obj2 = new StaticMethodDemo();

		System.out.println("====================");
		
		// static멤버는 클래스명.메소드명()
		StaticMethodDemo.test();

		System.out.println("====================");
		
		// Integer 클래스에 정의된 parseInt메소드는 static 메소드이므로 클래스 명으로 엑세스
		// 숫자형식의 문자열을 int 타입으로 변환하는 메소드
		int num = Integer.parseInt("100");
		System.out.println(num + 200);

	}

}
