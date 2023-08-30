package basic;

// 기본형 데이터의 캐스팅
public class PrimitiveTypeCastingTest {
	public static void main(String[] args) {
//		1. 자동형변환 - JVM 내부에서 자동으로 변환
		byte b = 100;
		short s = b;
		int i = s;
		long l = i;
		float f = l;
		double d = f;
		System.out.println(d);
		
		char data1 = 'A';
		int data2 = data1;
		System.out.println(data1);
		System.out.println(data2);

//		2. 명시적 형변환 - (캐스팅할 타입)을 정의

		byte b2 = (byte)1234;
		System.out.println(b2);
		
		int data3 = 97;
		System.out.println((char)data3);
		
		double result = 10/3;
		System.out.println(result);
		long result2 = Math.round((double)32/100*100);
		System.out.println(result2+"%");
		
	}
}
