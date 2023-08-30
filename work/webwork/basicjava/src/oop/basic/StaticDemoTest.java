package oop.basic;

public class StaticDemoTest {
	public static void main(String[] args) {

		StaticDemo obj1 = new StaticDemo();
		
		obj1.display();
		
		/*
		 * num 변수와 staticNum 변수는 접근 방법이 다르다.
		 * num은 인스턴스 변수이므로 객체참조 변수(obj1)를 통해서 사용
		 * staticNum 변수는 static변수 즉 객체의 소유가 아니라 클래스에 정의된 공유변수 이므로
		 * 어떤 객체의 소유도 아니다.
		 * 클래스명.정적변수 의 형식으로 엑세스 하는것이 권장된다.
		 */
		
		System.out.println("main ==> " + obj1.num + "," + StaticDemo.staticNum);

		StaticDemo obj2 = new StaticDemo();

		System.out.println("main ==> " + obj2.num + "," + obj2.staticNum);
		
		obj1.display();

		StaticDemo obj3 = new StaticDemo();

		System.out.println("main ==> " + obj3.num + "," + obj3.staticNum);
		
		obj1.display();
		
		// API에서 제공되는 static 변수도 동일한 방법으로 접근해서 사용
		
		System.out.println(Math.PI);
		
	}
	
}
