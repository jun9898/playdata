package statement;

import java.util.Scanner;

public class SwitchExam {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("점수 : ");
		int score = key.nextInt();
		if (score >= 0 && score <= 100) {
			int scoreTest = score / 10;
			switch (scoreTest) {
			case 1: 
			case 2: 
			case 3: 
			case 4:
			case 5: System.out.println("F"); break;
			case 6: System.out.println("D"); break;
			case 7: System.out.println("C"); break;
			case 8: System.out.println("B"); break;
			case 9:
			case 10: System.out.println("A"); break;
			}
		}
	}
}
