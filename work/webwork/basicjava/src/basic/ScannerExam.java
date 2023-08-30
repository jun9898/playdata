package basic;

import java.util.Scanner;

public class ScannerExam {
	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);

		System.out.print("국어 : ");
		int value1 = key.nextInt();

		System.out.print("수학 : ");
		int value2 = key.nextInt();

		System.out.print("영어 : ");
		int value3 = key.nextInt();
		
		int value4 = value1 + value2 + value3;
		
		System.out.println("국어 : " + value1);
		System.out.println("수학 : " + value2);
		System.out.println("영어 : " + value3);
		System.out.println("총점 : " + value4);
		System.out.println("평균 : " + (value4/3));

	}
}
