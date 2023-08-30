package basic;

public class OprTest05 {
	public static void main(String[] args) {
		int i = 0;
		i += 20;

		i += 30;
		System.out.println("i = " + i);

		i -= 30;
		System.out.println("i = " + i);

		i *= 30;
		System.out.println("i = " + i);

		i /= 30;
		System.out.println("i = " + i);
		
		int num1 = 90;
		// 연산 결과를 result에 저장한다.
		String result = num1 >= 90 ? "합격" : "불합격";
		System.out.println("삼항연산 결과 => " + result);
		
		int point = num1>90 ? 10000 : 100;
		System.out.println("삼항연산 결과 => " + point);
	}

}
