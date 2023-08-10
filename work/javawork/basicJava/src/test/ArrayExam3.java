package test;

public class ArrayExam3 {
	public static void main(String[] args) {
		int[] ia = new int[]{3,7,1,8,10,2,15,2,10};
		int[] ib = new int[]{1,2,3,4,5};

		int resultIa1 = 0;
		int resultIa2 = 0;

		int resultIb1 = 0;
		int resultIb2 = 0;

		for (int num : ia) {
			if (num % 2 == 0) {
				resultIa1 += num;
			} else {
				resultIa2 += num;
			}
		}

		for (int num : ib) {
			if (num % 2 == 0) {
				resultIb1 += num;
			} else {
				resultIb2 += num;
			}
		}
		System.out.println("( 배열 ia )");
		System.out.println("홀수의 합 : " + resultIa2);
		System.out.println("짝수의 합 : " + resultIa1);

		System.out.println("( 배열 ib )");
		System.out.println("홀수의 합 : " + resultIb2);
		System.out.println("짝수의 합 : " + resultIb1);
	}
}
