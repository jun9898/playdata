package test;

import java.util.ArrayList;
import java.util.Scanner;

public class ForLogicTest2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수를 입력하세요 : ");
		int result = sc.nextInt();
		
		ArrayList<Integer> listTest = new ArrayList<>();
		
		int i = 1;
		
		while (true) {

			if (result*i > 1000) {
				break;
			}

			listTest.add(result * i);
			
			i+=1;
		}
		
		System.out.println(result + "의 배수 개수 = " + listTest.size());
		
		int answer =  0;
		
		for (int num : listTest) {
			answer += num;
		}
		System.out.println(result + "의 배수의 합 = " + answer);
	}

}
