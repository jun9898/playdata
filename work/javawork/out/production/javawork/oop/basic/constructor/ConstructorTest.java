package oop.basic.constructor;
			
public class ConstructorTest {
	public static void main(String[] args) {
			
		// 1. 컴파일러가 기본생성자를 제공한다. (생성자를 정의하지 않는경우)
		Constructor obj = new Constructor();
			
		obj.setName("testname");
		obj.setId("IdTest");
		obj.setPass("PassTest");
			
		// 2. 매개변수가 7개인 생성자를 호출 
		// 	  => 객체를 생성하면서 객체에 정의된 멤버변수 7개를 초기화
		Constructor obj2 = new Constructor("1", "2", "3", "4", "5", "6", "7");
			
		System.out.println("성명 : "+ obj.getName());
		System.out.println("아이디 : "+ obj.getId());
			
		System.out.println("===================");
			
		System.out.println("성명 : "+ obj2.getName());
		System.out.println("아이디 : "+ obj2.getId());
			
		System.out.println("===================");
			
		Constructor obj3 = new Constructor("1", "2", "3", "4", "5", "6", "7", 8);
	}		
			
}			
			