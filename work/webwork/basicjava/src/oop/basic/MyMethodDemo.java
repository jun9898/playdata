package oop.basic;

public class MyMethodDemo {
		
		
	public void printGuGu(int dan) {
		for(int i=1;i<=9;i++) {
			System.out.println(dan + "*"+i+"="+(dan*i));
		}
	}

	public void printGuGu() {
		for(int dan=2;dan<=9;dan++) {
			for(int i=1;i<=9;i++) {
				System.out.print(dan + "*"+i+"="+(dan*i)+"\t");
			}
			System.out.println();
		}
	}
	
	// 매개변수 -> opr, num1, num2
	// 리턴값 -> 연산결과
	public int calc(int i,int x,int y) {
		int result = 0;
		if (i == 1) {
			result = x+y;
		} else if (i == 2) {
			result = x*y;
		} else if (i == 3) {
			result = x-y;
		} else if (i == 4) {
			result = x/y;
		}
		return result;
	}
	
	// 매개변수 -> int 배열
	// 리턴값 없음
	public void calcArr(int[] arr) {
		int result1 = 0;
		int result2 = 0;
		for (int num : arr) {
			if (num % 2 == 0) {
				result1 += num;
			} else {
				result2 += num;
			}
		}
		System.out.println("홀수의 합 : " + result2);
		System.out.println("짝수의 합 : " + result1);
	}
}
