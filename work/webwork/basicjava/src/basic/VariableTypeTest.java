package basic;

public class VariableTypeTest {
	public static void main(String[] args) {

		int i = 10;
		int j = 10;

		System.out.println("=======기본형=======");
		if (i == j) {
			System.out.println("기본형");
		} else {
			System.out.println("기본형 다르다");
		}

		String str = new String("test");
		String str2 = new String("test");

		System.out.println("=======참조형=======");
		if (str == str2) {
			System.out.println("참조형");
		} else {
			System.out.println("참조형 다르다");
		}

		// new 를 선언해주면 참조값으로 비교해 다르다고 나오는데
		// new 를 선언하지 않고 변수를 비교하면 참조값이 같다고 나온다
		// 왜일까
		String str3 = "test";
		String str4 = "test";

		System.out.println("=======참조형Test=======");
		if (str3 == str4) {
			System.out.println("참조형?");
		} else {
			System.out.println("참조형 다르다");
		}
	}
}