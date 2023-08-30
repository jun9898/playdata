package oop.basic.constructor;

public class Student {
	
	private String name;
	private int age;
	private int id;

	public Student(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public void display() {
		System.out.println("이름 : " + name + " 나 이 : " + age + 
				" 학\t번 : " + id);
	}
}