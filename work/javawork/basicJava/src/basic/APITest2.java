package basic;

import java.util.Random;

// 참조형 변수 사용방법
public class APITest2 {
	public static void main(String[] args) {
		int a = 10;
		System.out.println("기본형 변수 => " +a);
		
		Random rand = new Random();

		// 참조값이 출력됨
		System.out.println("참조형 변수 => " +rand);

		String str = new String("Java programing");

		/* 
		 * String class 에 정의되어 있는 length 메소드를 사용
		 * 1. String 클래스의 기능을 사용하기 위해 String 클래스를 메모리에 올리기
		 * 2. 메모리에 올라간 STring 클래스를 사용하기 위해 동일한 타입의 변수를 선언해서 할당하기
		 * 3. .연산자를 이용해서 힙에 할당된 String을 찾아가서 필요한 기능을 참조해서 사용
		 */
		int num = str.length();
		
		for (int i = 0; i <= num; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
