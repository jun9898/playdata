package basic;

// 논리연산자 - ||, &&
public class OprTest04 {
	public static void main(String[] args) {
		int num1 = 200;
		String str = null; // null은 참조형 변수에 초기값
//		str.length();
//		System.out.println(num1>100 | str.length()>0);

//		||연산자는 or연산의 특성을 이용해서 첫 번째 항이 true면 || 연산자 뒤의 항은 검사하지 않고 넘어간다.
		System.out.println(num1>100 || str.length()>0);
//		System.out.println(num1<100 || str.length()>0);
		
//		&&
//		System.out.println(num1<100 & str.length() > 0);
//		&&연산자는 and연산의 특성을 이용해서 첫 번째 항이 false면 && 연산자 뒤의 항은 검사하지 않고 넘어간다.
		System.out.println(num1<100 && str.length() > 0);
	}

}
