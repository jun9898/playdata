package oop.inheritance;

public class Teacher  extends Person{

	private String subject;

	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void display() {
		super.displayTest();
		System.out.println(" 담당과목 : " + subject);
	}
}
