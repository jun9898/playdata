package statement;

import java.util.Scanner;

public class IfExam01 {
	public static void main(String[] args) {

		int num = new Scanner(System.in).nextInt();
		
		if (num%5 == 0) {
			System.out.println("5의 배수입니다");
		} else {
			System.out.println("5의 배수가 아닙니다.");
		}
	}
}
