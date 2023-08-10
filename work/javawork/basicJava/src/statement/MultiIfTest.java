package statement;

import java.util.Scanner;

public class MultiIfTest {
	public static void main(String[] args) {
		// 주민먼호의 입력을 받고 남자, 여자, 기타를 출력하기
		Scanner key = new Scanner(System.in);
		System.out.print("주민번호 입력 : ");
		String ssn = key.next();
		
		if (ssn.charAt(0) == '1' || ssn.charAt(0) == '3' ) {
			System.out.println("남자");
		} else if (ssn.charAt(0) == '2' | ssn.charAt(0) == '4') {
			System.out.println("여자");
		} else {
			System.out.println("기타");
		}
		
	}

}
