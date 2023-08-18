package assignment.date0818;

public class Coffee1 extends Beverage {
	
	static int amount;

	public Coffee1(String name) {
		super(name);
		switch (name) {
		case "Americano": 
			setPrice(1500);
			break;
		case "CafeLatte":
			setPrice(2500);
			break;
		case "Cappuccino":
			setPrice(3000);
			break;
		}
		amount += 1;
	}

	@Override
	void calcPrice() {

	}

}
