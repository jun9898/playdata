package statement;

import java.util.Scanner;

public class WhileExam2_GuGu {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("단을 입력하세요 : ");
		int dan = sc.nextInt();

		int i = 1;
		
		while (true) {
			System.out.println(dan + " * " + i +" = " + dan*i);
			if (i >= 9) {
				break;
			}else {
				i += 1;
			}
		}
	}
}
