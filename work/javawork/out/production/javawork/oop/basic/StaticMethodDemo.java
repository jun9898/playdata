package oop.basic;
// static 메소드의 특징과 static 블럭
public class StaticMethodDemo {
	
	static int staticNum;
	// static 블럭 - 클래스로더에 의해서 클래스에 대한 정보가 method area에 올라갈때 한 번 실행
	static {
		staticNum = 100;
		System.out.println("static블럭 - 클래스가 로딩될때 한 번 실행하는 코드를 정의할 목적");
		System.out.println("static블럭 - 자원에 대한 정보를 한 번 인식시키거나 엑세스할때");
		System.out.println("static블럭 - 클래스가 로딩될때 한 번만 실행되므로 static 변수를 초기화 할 목적");
	}

	public StaticMethodDemo() {
		System.out.println("StaticMethodDemo의 기본 생성자");
	}
	
	// static method와 non-static method의 차이점과 사용방법
	// static method 는 static member의 값을 조작하거나 유틸리티처럼 메소드를 편하게 사용하기 위한 목적
	// 자원을 엑세스 하거나 모든 객체에서 공통으로 사용하는 기능을 표현하는 경우 사용
	public static void test() { // 정적메소드
		// 1. static method 에서 static method 호출
		// => 일반적인 방법으로 접근
		
		// 자신의 클래스 내부에서 선언된 메소드는 메소드 명만 입력해서 호출할 수 있다.
		show();
		System.out.println("test");
		
	}

	public void display() {
		// 2. non - static method 에서 non - static method 호출
		// => 일반적인 방법으로 접근
		change();
		System.out.println("display");
	}

	public void change() { // 인스턴스 메소드
		// 3. non - static method 에서 static method 호출
		// => 일반적인 방법으로 접근
		show();
		System.out.println("change");
	}

	public static void show() { // 정적메소드
		// 4. static method 에서 non - static method 호출
		// show가 메모리에 있는 상태에 바로 examtest를 확인할 수 없으므로 에러 발생
		// 같은 클래스에 정의된 메소드라고 하더라고
		// static 메소드 안에서 non - static 메소드를 호출하는 경우
		// 객체생성 후 참조변수를 통해서 호출해야 한다.
		// examtest();  => error
		
		StaticMethodDemo obj = new StaticMethodDemo();
		obj.examtest();
		System.out.println("show");
		
	}

	public void examtest() { // 인스턴스 메소드
		System.out.println("examtest");
		
	}
}
