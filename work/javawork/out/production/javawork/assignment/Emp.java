package assignment;

public class Emp {
	
	private String id;
	private String name;
	private int baseSalry;
	
	private double salary;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBaseSalry(int baseSalry) {
		this.baseSalry = baseSalry;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBaseSalry() {
		return baseSalry;
	}

	public double getSalary(double bonus) {
		salary = baseSalry + baseSalry * bonus;
		return salary;
	}
	
	public String toString() {
		return (name + "("+ id +") 사원의 기본급은 " + baseSalry + "원 입니다.");
		
	}

}
