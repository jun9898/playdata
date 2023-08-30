package basic;

// 기본형 변수에 저장되는 값(리터럴)

public class PrimitiveTypeValueTest {
	public static void main(String[] args) {

		int num = 100; 
		num = 200;

		// 논리형 - boolean
		boolean boolVal = false;
		
		// 정수형 - byte, short, int, long
		// 정수형 리터럴은 int 타입
		// byte b = 127
		//	   ---  ---
		// 	   변수  리터럴
		//	  byte  int
		 byte b = 127;
		//byte b2 = 128; 에러상황
		// 강제 형변환
		// 강제 형변환으로 인해 b2의 값이 -46으로 출력됨

		 byte b2 = (byte)1234; 
		 System.out.println("byte 변수 => " + b);
		 System.out.println("캐스팅된 byte 변수 => " + b2);
		 
		 short s = 32767;
		 System.out.println(s);
		 
		 int i = 2147483647;
		 long l = 2147483648L; // 정수의 기본 리터럴이 int 형이기 떄문에 long 타입의 리터럴을 사용해야 한다. (접미사에 L 추가)

		 System.out.println(i);
		 System.out.println(l);
		 
		 // 실수형 리터럴 float, double
		 // 실수형 리터럴의 기본 타입을 double
		 
		 double d = 10.5;
		 System.out.println(d);

		 float f = 10.5f;// 마찬가지로 접미사를 붙혀줘야 한다. 
		 System.out.println(f);

		 // 문자형 리터럴
		 char c = 'A'; // 캐릭터는 작은 따옴표
		 System.out.println(c);
		 System.out.println((int)c); // c 변수에 저장된 값을 int로 강제 형변환하여 출력 아스키값으로 출력된다.
		 
		 // 참조형 중에서 String은 기본형처럼 리터럴로 할당할 수 있다.
		 String str = "참조형인 String의 리터럴은 큰따옴표로 표현합니다";
		 System.out.println(str);
	}
}
