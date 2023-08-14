package oop.basic;

// Person 클래스를 테스트 하기 위한 클래스
public class PersonTest {
	public static void main(String[] args) {
		
		// 값을 직접 대입해주는 방법은 권장되지 않는다.
		// 아무곳에서나 접근할 수 있고 오버라이딩에 취약하기 때문
//		Person p1 = new Person();
//		p1.name = "JB";
//		p1.age = 24;
//		p1.addr = "금천";
//		
//		System.out.println("성명 : " + p1.name);
//		System.out.println("주소 : " + p1.addr);
//		System.out.println("나이 : " + p1.age);
//		
//		System.out.println("===================");
//		
//		Person p2 = new Person();
//		p2.name = "HE";
//		p2.age = 22;
//		p2.addr = "화곡";
//
//		System.out.println("성명 : " + p2.name);
//		System.out.println("주소 : " + p2.addr);
//		System.out.println("나이 : " + p2.age);

		System.out.println("===================");

		Person jbj = new Person();
		jbj.setName("byeong jun");
		jbj.setAddr("금천");
		jbj.setAge(24);
		
		System.out.println(jbj.getName());
		System.out.println(jbj.getAddr());
		System.out.println(jbj.getAge());
		
		System.out.println("===================");

	}

}