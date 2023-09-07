package basic;

public class Calc {
	public int clac(int num1, String method, int num2) {
		System.out.println("calc 메소드 호출");
		
		// 비즈니스 로직 구현
		int result = 0;
		switch (method) {
		case "+": {
			result = num1 + num2;
			break;
		}
		case "-": {
			result = num1 - num2;
			break;
		}
		case "*": {
			result = num1 * num2;
			break;
		}
		case "/": {
			result = num1 / num2;
			break;
		}
		}
		
		return result;

	}

}
