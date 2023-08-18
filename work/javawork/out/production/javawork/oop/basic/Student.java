package oop.basic;

public class Student {
	
	private String name;
	private int age;
	private int id;

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getId() {
//		return id;
//	}


	// alt + shift + s
	// setter and getter 생성 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void display() {
		System.out.println("이름 : " + name + " 나 이 : " + age + 
				" 학\t번 : " + id);
	}

	// 선언된 클래스가 동일하면 객체생성을 하지 않고 메소드를 바로 호출 가능하다.
	public void print() {
		display();
	}
}