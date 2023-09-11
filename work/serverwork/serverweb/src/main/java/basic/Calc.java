package basic;

public class Calc {
	public int calc(int num1, String method,int num2) {
		System.out.println("calc메소드 호출");
		int result = 0;
		switch(method.charAt(0)) {
			case '+': 
				result=num1+num2;
				break;
			case '-': 
				result=num1-num2;
				break;
			case '*': 
				result=num1*num2;
				break;
			case '/': 
				result=num1/num2;
				break;
		}
		return result;
	}
}
