package oop.basic;

// 메소드를 유형별로 정의
public class MyMethod {

	// 1. 매개변수가 없고 리턴값이 없는 메소드
	// => * 기호를 10회 출력하고 싶은 개발자만 활용 가능
	public void display() {
		for (int i = 0; i <= 10 ; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	// 2. 리턴값이 없고 매개변수가 한개인 메소드
	public void display(String str) {
		for (int i = 0; i <= 10 ; i++) {
			System.out.print(str);
		}
		System.out.println();
	}
	
	// 3. 리턴값이 없고 매개변수가 두개인 메소드
	public void display(String str, int num) {
		for (int i = 0; i < num ; i++) {
			System.out.print(str);
		}
		System.out.println();
	}

}
