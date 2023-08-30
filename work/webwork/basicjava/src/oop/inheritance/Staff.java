package oop.inheritance;

public class Staff extends Person {

	private String dept;

	public Staff(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}


	public void display() {
		super.displayTest();
		System.out.println(" 부\t서 : " + dept);
	}
}
