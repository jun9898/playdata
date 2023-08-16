package oop.basic;

public class Staff {

	private String name;
	private int age;
	private String dept;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int setAge() {
		return age;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void display() {
		System.out.println("이름 : " + name + " 나 이 : " + age + 
				" 부\t서 : " + dept);
	}
}
