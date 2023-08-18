package statement;

import java.util.Scanner;

public class IfTest01 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int num1 = key.nextInt();
		if(num1 >= 100) {
			System.out.println("통과");
			System.out.println("종료");
		}
	}

}
