package basic;

import java.util.Random;

public class APIExam02 {
	public static void main(String[] args) {
		// 1. java.util 패키지의 Random 클래스를 이용해서 작업하기
		// - 참조변수명 : rand
		// - nextInt 메소드를 호출해서 램덤수를 다음과 같이 출력하기
		// 랜덤수 : ___
		
		// 2. 1부터 100까지의 랜덤수를 출력할 수 있도록
		
		Random rand = new Random();
		int num = rand.nextInt();
		System.out.println("랜덤수 : " + num);

		int num2 = rand.nextInt(100);
		System.out.println("랜덤수 : " + num2);
	}
}
