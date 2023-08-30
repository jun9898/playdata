package oop.basic.constructor;

public class Staff {

	private String name;
	private int age;
	private String dept;

	public Staff() {
		
	}

	public Staff(String name, int age, String dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public void display() {
		System.out.println("이름 : " + name + " 나 이 : " + age + 
				" 부\t서 : " + dept);
	}
}
