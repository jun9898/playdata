package statement;

import java.util.Scanner;

public class WhileTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		while (true) {
			System.out.print("1 입력 : ");
			int a = sc.nextInt();
			if (a == 1) {
				break;
			}

		}
	}

}
