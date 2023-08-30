package array;

import java.util.Random;

public class ArrayExam2 {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int[] arr = new int[5];
		
		for (int i = 0; i < 5; i++) {
			int a = rand.nextInt(100)+1;
			arr[i]= a; 
			if (arr[i] % 2 == 0) {
				System.out.println(i + "번 요소 -> " + arr[i] + " (짝수)");
			} else {
				System.out.println(i + "번 요소 -> " + arr[i] + " (홀수)");
			}
		}
	}

}
