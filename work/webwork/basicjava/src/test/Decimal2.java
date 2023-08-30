package test;

public class Decimal2 {
	public static void main(String[] args) {
		int count = 0;

		System.out.println("소수 구하기");
		
		
		for (int i = 2; i <=100; i++ ) {
			int num = 0;
			for (int j = 1; j < i; j++ ) {
				if (i%j == 0) {
					num += 1;
				} 
			}
			if (num < 2) {
				System.out.println(i + " => 소수입니다.");
				count += 1;
			}
		}
		System.out.println("소수의 개수 => " + count);
	}
}
