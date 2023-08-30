package basic;

// String 클래스의 사용
public class APIExam01 {
	public static void main(String[] args) {
		
		// length을 호출해서 결과 출력해보기
		String str = new String("안녕하세요");
		int result = str.length();
		System.out.println("str.length => " + result);
		
		// charAt을 호출해서 결과 출력해보기
		char result2 = str.charAt(2);
		System.out.println("str.charAt => " + result2);
	}
}