package test;

import java.util.ArrayList;
import java.util.Scanner;

public class IfLogicTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> listTest = new ArrayList<>();
		int answer = 0;

		System.out.print("입력값");
		int result = sc.nextInt();
		int result2 = sc.nextInt();
		
		int val = 0;
		
		if (result < result2) {
			val = result;
		} else {
			val = result2;
		}
		
		for (int i = 1; i <= val; i++) {
			if (result%i == 0 & result2%i == 0) {
				listTest.add(i);
			}
		}
		
		for (int num : listTest) {
			if (answer < num) {
				answer = num;
			}
		}
		
		System.out.println("실행결과 ");
		System.out.println(answer);
		
		
	}

}
