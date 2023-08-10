package statement;

import java.util.Random;

public class IfExam02 {
	public static void main(String[] args) {
		Random rand = new Random();
		int a = rand.nextInt(10)+1;
		if (a > 0) {
			if (a % 2 == 0) {
				System.out.println(a + " : 양수이면서 짝수입니다.");
			} else {
				System.out.println(a + " : 양수이면서 홀수입니다.");
			}
		} else {
			System.out.println("음수입니다.");
		}
	}
}
