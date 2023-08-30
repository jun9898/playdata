package test;

import java.util.Scanner;

import oop.basic.MyMethodDemo;

public class Calc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("****미니계산기****");
		System.out.println("1. 더하기");
		System.out.println("2. 곱하기");
		System.out.println("3. 빼기");
		System.out.println("4. 나누기");
		System.out.print("연산자를 선택하세요.");

		int i = sc.nextInt();

		System.out.print("숫자를 입력하세요.");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		MyMethodDemo calcTest = new MyMethodDemo();
		int result = calcTest.calc(i, x, y);

		System.out.println("계산결과 => " + result);




		
	}

}
