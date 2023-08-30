package statement;

import java.util.Scanner;

public class SwitchTest1 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("단을 입력하세요 : ");
		int dan = key.nextInt();
		switch (dan) {
		 case 1: System.out.println("1단"); break;
		 case 2: System.out.println("2단"); break;
		 case 3: System.out.println("3단"); break;
		 case 4: System.out.println("4단"); break;
		 default : System.out.println("기타");

		}

		
	}

}
