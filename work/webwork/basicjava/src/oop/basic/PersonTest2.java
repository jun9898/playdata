package oop.basic;

// Person2 클래스를 테스트 하기 위한 클래스
public class PersonTest2 {
	public static void main(String[] args) {
		
		Person2 p1 = new Person2();
		// Setter 메소드 호출
		p1.setName("전병준");
		p1.setAddr("금천구");
		p1.setAge(26);
		
		System.out.println("===================");
		
		// Getter 메소드 호출
		System.out.println("성명 : " + p1.getName());
		System.out.println("주소 : " + p1.getAddr());
		System.out.println("나이 : " + p1.getAge());

		System.out.println("===================");

	}

}