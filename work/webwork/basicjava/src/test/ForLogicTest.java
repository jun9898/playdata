package test;

import java.util.Scanner;

public class ForLogicTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 20보다 작은 정수를 입력하세요 : ");
		int result = sc.nextInt();
		
		if (result < 2 | result > 20) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
		} else {
			for (int i = 1; i < 10; i++) {
				System.out.println(result + " * " + i + " = " + (result * i));
			}
		}
		
	}

}
