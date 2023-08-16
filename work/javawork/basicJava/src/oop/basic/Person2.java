package oop.basic;

// 자바의 특징에 맞게 클래스를 정의
// 클래스를 정의하는 경우 멤버변수(클래스의 속성, 클래스의 구성요소, 클래스에서 다루는 데이터)는 private 으로
// 선언해서 외부에서 접근할 수 없도록 정보를 은닉하고 public 메소드를 통해서 접근할 수 있도록 구현한다.

public class Person2 {

	// 정보를 은닉
	private String name;
	private String addr;
	private int age;

	// 모든 멤버변수가 private으로 선언되어 있으므로 값을 설정하는 메소드와 값을 가져오기 위해 사용하는 메소드가 필요
	// 객체의 멤버변수에 값을 설정하는 메소드

	// 메소드명 : set + 값이 저장될 멤버변수의 첫 글자를 대문자로 변경한 이름
	// ex) name변수에 값을 설정하는 메소드를 정의
	//	   setName
	public void setName(String name) {
		// 멤버변수 name의 값을 매개변수의 값으로 변경하는 메소드
		// 멤버변수 name = 매개변수 name
		this.name = name;
		// 현재 작업중인 객체에 매개변수를 할당하라는 뜻
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// 메소드명 : get + 값을 호출할 멤버변수의 첫 글자를 대문자로 변경한 이름
	// ex) name변수에 값을 호출하는 메소드를 정의
	//	   getName
	public String getName() {
		// 멤버변수 name의 값을 return 하는 메소드
		return name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public int getAge() {
		return age;
	}
}
