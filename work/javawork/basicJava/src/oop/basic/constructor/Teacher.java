package oop.basic.constructor;

public class Teacher {

	private String name;
	private int age;
	private String subject;

	public Teacher() {
		
	}

	public Teacher(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}


	public void display() {
		System.out.println("이름 : " + name + " 나 이 : " + age + 
				" 담당과목 : " + subject);
	}

}
