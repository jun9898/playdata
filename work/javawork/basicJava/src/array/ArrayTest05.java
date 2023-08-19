package array;

import java.util.Random;

public class ArrayTest05 {
	// 기본형 배열은 배열의 각 요소에 값이 저장되지만
	// 참조형 배열은 배열의 각 요소에 객체의 주소가 저장된다
	public static void main(String[] args) {

		String[] strArr = new String[3];

		Random[] randArr = new Random[3];

		System.out.println(strArr);
		System.out.println(strArr[0]);
		
		// 여기서 randArr는 Random타입의 arr가 선언되었을 뿐 아직 Random 객채가 포함되어 있지 않다.
		// 따라서 randArr[0]에는 Random 객체가 아닌 null이 포함되어 있다.

		/*
		int a = randArr[0].nextInt();
		System.out.println(a);

		에러 발생
		Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.util.Random.nextInt()" because "randArr[0]" is null
		at Array.ArrayTest05.main(ArrayTest05.java:20)
		 */

		// 이 단계에서 각 배열의 주소에 Random 객체를 할당해주어 Random 매소드를 사용할 수 있게 된다.
		randArr[0] = new Random();
		randArr[1] = new Random();
		randArr[2] = new Random();
		
		for (int i = 0; i<randArr.length; i++) {
			System.out.println(randArr[i]);
		}
		
		strArr[0] = new String("java");
		strArr[1] = new String("oracle");
		strArr[2] = new String("jdbc");
		
		for (int i = 0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
		// 참조형 배열도 선언과 생성과 초기화를 한번에 작업할 수 있다.
		String[] strArr2 = {"java", "oracle", "jdbc"};
		Random[] randArr2 = {new Random(), new Random(), new Random()};
		
		// 향상된 for문
		int[] intArr = new int[10];
		
		for (int num : intArr) {
			System.out.println(num);
		}

		System.out.println("==================");

		for (String str : strArr2) {
			System.out.println(str);
			
		}
	}

}
