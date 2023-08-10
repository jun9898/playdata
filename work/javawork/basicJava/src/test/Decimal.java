package test;

import java.util.Scanner;

public class Decimal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("2 ~ 100 사이의 정수를 입력하세요. : ");
		int num = sc.nextInt();
		boolean flag = true;
		
		for (int i = 2; i < num; i++) {
			if (num % i == 0 ) {
				flag = false;
			}
		}
		if (flag == true) {
			System.out.println(num + "는(은) 소수입니다.");
		} else {
			System.out.println(num + "는(은) 소수가 아닙니다.");
		}
	}
}
