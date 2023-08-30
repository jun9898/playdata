package basic;

// 비교 연산자
public class OprTest02 {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		int num3 = 200;
		// num1 변수가 + 연산자에 앞의 값이 문자열이므로 문자열화
		// + 연산자는 더하기와 연결 연산자의 역할을 함
		// 문자열 앞에 + 연산자의 첫번째 항이 문자열이면 문자열로 모두 변환된다.
		// System.out.println("더한 결과 = " + num1+num2);
		System.out.println("더한 결과 = " + (num1+num2));
		System.out.println("num1 > num2 -> "+ (num1>num2));
		System.out.println("num1 >= num2 -> "+ (num1>=num2));
		System.out.println("num1 < num2 -> "+ (num1<num2));
		System.out.println("num1 <= num2 -> "+ (num1<=num2));

		System.out.println("num1 == num2 -> "+ (num1==num2));
		System.out.println("num2 == num3 -> "+ (num2==num3));
		System.out.println("num1 != num3 -> "+ (num2!=num3));
		
	}

}
