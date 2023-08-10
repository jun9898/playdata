package basic;

import java.util.Scanner;

// Scanner 사용방법
// => 키보드를 통해 직접 입력받은 값을 타입에 따라 각각 읽어서 사용할 수 있도록 지원
// => 표준입력으로 입력된 값을 읽어서 리턴하는 기능들을 제공
// 	  ------
//	  키보드로 입력 : System.in
public class ScannerTest {
	public static void main(String[] args) {

		Scanner key = new Scanner(System.in);
		System.out.print("문장을 입력하세요 : ");
		String value = key.nextLine();
		System.out.println("value => " + value);
		
		
		// Scanner를 이용하면 키보드로 입력하는 값을 읽을 수 있고
		// next() 는 spacebar 나 enter를 만나기 전까지 입력된 문자열을 읽어서 리턴
		System.out.print("input String value : ");
		String value1 = key.next();
		System.out.println("value1 => " + value1);
		
		System.out.print("input int value : ");
		int value2 = key.nextInt();
		System.out.println("value2 => " + value2);

		System.out.print("input double value : ");
		double value3 = key.nextDouble();
		System.out.println("value3 => " + value3);
	}
}
