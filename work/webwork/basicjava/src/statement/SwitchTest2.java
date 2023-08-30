package statement;

import java.util.Scanner;

public class SwitchTest2 {
	public static void main(String[] args) {
		
		Scanner key = new Scanner(System.in);
		System.out.print("단을 입력하세요 : ");
		String ssn = key.next();
		
		switch (ssn.charAt(0)) {
		case '1': 
		case '3': 
			System.out.println("남자");
			break;
		case '2': 
		case '4': 
			System.out.println("여자");
			break;
		default:
			System.out.println("기타");
		}
	}
}
