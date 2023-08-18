package basic;

// 자바에서 로컬 변수의 특징
public class LocalVariableTest {
	int i; // 로컬 변수가 아닌 필드값(member variable)
	public static void main(String[] args) {
		int j = 10; // 로컬 변수 - main 블럭에서 정의된 변수

		int num;
//		1. 로컬 변수는 사용하기 전에 초기화(= 연산자로 값을 할당하는 작업) 해야한다.
//		System.out.println(num); 초기화가 되지 않아 에러가 발생
		if(j >= 10) {
			int val = 100; // 로컬변수 - if 블럭에서 정의된 변수
			System.out.println("j = " + j);
			System.out.println("val = " + val);
		}
//		2. 로컬 변수는 선언된 블럭 내부에서만 사용할 수 있다.
//		=> 블럭이 끝나면 메모리에서 해제
//		System.out.println("val = " + val); 로컬 변수이기 때문에 if문을 나간 순간 에러 발생
	}
}
