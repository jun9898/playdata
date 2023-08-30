package oop.polymorphism;

public class Sales extends Employee implements Bounus {

	public Sales() {
	}

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incentive(int pay) {
		setSalary(getSalary()+(pay*120)/100);
	}

	@Override
	public double tax() {
		return (getSalary()*13)/100;
	}
	
	

}
