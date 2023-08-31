package oop.intensification;

import java.util.Scanner;

public class Hex2Decimal {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		
		while (flag == true) {
			System.out.print("Enter the hex value ('quit' for exit) : ");
			String hex = sc.next();
			// String 문자열 비교는 equals
			if (hex.equals("quit")) {
				System.out.println("Bye !!!");
				flag = false;
			} else {
				int result = 0;
				try {
					result = Integer.parseInt(hex,16);
					System.out.println("hex input : " +hex);
					System.out.println("decimal output : " +result);

				} catch (Exception e) {
					System.out.println("Invalid hex !!!");
				}
			}
		}
	}
}
