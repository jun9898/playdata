package test;

import java.util.Scanner;

public class FareTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Menu-----");
		System.out.println("1. 가정용 (liter당 50원)");
		System.out.println("2. 상업용 (liter당 45원)");
		System.out.println("3. 공업용 (liter당 30원)");
		System.out.println("--------------");
		System.out.print("메뉴를 선택하세요 => ");
		int i = sc.nextInt();

		System.out.print("사용량을 입력하세요.");
		int x = sc.nextInt();
		System.out.println("--------------");
		int result = 0;
		
		switch (i) {
		case 1: 
			result = x*50;
			break;
		case 2:
			result = x*45;
			break;
		case 3:
			result = x*30;
			break;
		} 
		System.out.println("사용자 코드 : " + i);
		System.out.println("사용 요금 : " + result);
		System.out.println("총수도 요금 : " + (result*0.05+result));
	}
}
