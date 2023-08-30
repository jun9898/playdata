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

		String str = new String("Java programming");

		/* 
		 * String class 에 정의되어 있는 length 메소드를 사용
		 * 1. String 클래스의 기능을 사용하기 위해 String 클래스를 메모리에 올리기
		 * 2. 메모리에 올라간 STring 클래스를 사용하기 위해 동일한 타입의 변수를 선언해서 할당하기
		 * 3. .연산자를 이용해서 힙에 할당된 String을 찾아가서 필요한 기능을 참조해서 사용
		 *     ------------------
		 *     메소드의 호출
		 * 4. 메소드의 실행 결과(return)가 있으면 결과와 동일한 타입(return type)의 변수를 선언해서
		 * 	  메소드의 실행 결과를 저장해서 사용한다
		 * 5. 매개변수를 확인하고 알맞은 값을 넣어서 호출한다.
		 */
		
		// 메소드의 호출결과가 있는 경우 같은 타입의 변수를 선언해서 저장해야 한다.
		int num = str.length();
		System.out.println("결과 => " + num);
		
		String result = str.toUpperCase();
		System.out.println("결과 => " + result);
		




//		for (int i = 0; i <= num; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//
//		for (int i = 0; i <= num; i++) {
//			for (int j = num-1; j >= i; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
	}
}
