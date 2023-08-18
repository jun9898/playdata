package basic;

public class StatementTest {
	public static void main(String[] args) {
//		 변수의 선언 - 자바는 무조건 데이터 타입을 명시하고 변수를 선언해야 한다.

//		 데이터 타입 변수명 = 값
//		 여기서 데이터 타입과 변수명의 값은 같음을 의미하는 것이 아닌 할당을 의미함
		int num1 = 100; // 변수의 정의와 초기화를 한번에 작업
		int num2; // 우선 변수를 정의하고 그 값을 후에 할당해주는 작업
		// 이때 기존의 정의된 이름과 동일한 이름으로 변수를 정의하면 에러가 발생
		num2 = 200;
		System.out.println("num1의 값은 = " + num1);
		System.out.printf("num2의 값은 = %d \n", num2);

		// 산술 연산자도 가능
		int result = num1+num2;
		System.out.println("+ 연산 결과 = " + result);
		
		result = num2 - num1;
		System.out.println("- 연산 결과 = " + result);

		result = num2 * num1;
		System.out.println("* 연산 결과 = " + result);

		result = num1 / 3; // 몪 연산
		System.out.println("num1 / 3 연산 결과 = " + result);

		result = num1 % 3; // 나머지 연산
		System.out.println("num1 % 3 연산 결과 = " + result);
		// result 란 변수에 계속해서 값을 대입해줘서 재활용하는 모습
		
		for (int a = 1; a <= 20; a++) {
		System.out.println(a);
		}
	}
}
