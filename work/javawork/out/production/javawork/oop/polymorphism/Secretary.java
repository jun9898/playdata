package oop.polymorphism;

public class Secretary extends Employee implements Bounus{

	public Secretary() {
		super();
	}

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (pay * 80)/100);
	}

	@Override
	public double tax() {
		return (getSalary()* 10)/100;
	}

}
