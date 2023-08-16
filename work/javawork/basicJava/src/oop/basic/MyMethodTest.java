package oop.basic;

// MyMethod 클래스에 정의된 메소드를 사용
public class MyMethodTest {
	public static void main(String[] args) {

		MyMethod obj = new MyMethod();
		
		System.out.println("**********program start**********");

		// 1. 리턴값이 없고 매개변수가 한개인 메소드
		System.out.println("++++++++step01++++++++");
		obj.display();
		obj.display();
		System.out.println("++++++++step02++++++++");
		// 2. 리턴값이 없고 매개변수가 한개인 메소드
		obj.display("★");
		obj.display("§");
		obj.display("▨");
		System.out.println("++++++++step03++++++++");
		// 3. 리턴값이 없고 매개변수가 두개인 메소드
		obj.display("★", 4);
		obj.display("§", 15);
		obj.display("▨", 24);
		
		int resdata = obj.add(100, 200);
		System.out.println("메소드 호출 결과 => " + resdata);
		if (resdata > 200) {
			System.out.println("완료");
		} else {
			System.out.println("다시 작업");
		}
		
		// 메소드로 호출한 값을 변수에 초기화 시켜주지 않아도 사용이 가능하다
		if (obj.add(10, 20) > 200) {
			System.out.println("완료");
		} else {
			System.out.println("다시 작업");
		}
		
	}
}
