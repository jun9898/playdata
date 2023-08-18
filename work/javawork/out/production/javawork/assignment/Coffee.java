package assignment;

class Beverage {

	private String type;
	private int price;
	
	public Beverage() {
	}
	
	public Beverage(String type, int price) {
		super();
		this.type = type;
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

public class Coffee extends Beverage {

	private String name;
	
	public Coffee() {
	}

	public Coffee(String type, int price, String name) {
		super(type, price);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println("타입 : " + getType() + ", 가격 : " + 
	getPrice() + ", 이름 : " + name);
	}

}
