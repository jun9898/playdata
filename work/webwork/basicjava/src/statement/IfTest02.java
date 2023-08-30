package statement;

import java.util.Scanner;

// if else 제어구문
public class IfTest02 {
	public static void main(String[] args) {
		// 점수 입력을 스캐너로 받아서 90점 이상은 pass 나머지는 fail이 되게
		// 단 점수가 0보다 작거나 큰 값을 입력받으면 "잘못입력" 출력
		Scanner key = new Scanner(System.in);
//			System.out.print("점수를 입력하세요 : ");
//			int num1 = key.nextInt();
//			if (num1 == 100) {
//				System.out.println("while test");
//				return;
//			} else if (num1 < 0 | num1 > 100) {
//				System.out.println("잘못 입력");
//			} else if(num1 >= 90) {
//				System.out.println("pass");
//			} else if (num1 <90) {
//				System.out.println("fail");
//			}
//		}
		// ====================================

		int num1 = key.nextInt();
		if(num1 >=0 & num1 <=100 ) {
			if(num1 >= 90) {
				System.out.println("pass");
			} else if (num1 <90) {
				System.out.println("fail");
			}
		}
	}
}
