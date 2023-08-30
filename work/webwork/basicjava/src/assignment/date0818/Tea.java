package assignment.date0818;

public class Tea extends Beverage {
	
	static int amount;

	public Tea(String name) {
		super(name);
		switch (name) {
		case "lemonTea": 
			setPrice(1500);
			break;
		case "ginsengTea":
			setPrice(2000);
			break;
		case "redginsengTea":
			setPrice(2500);
			break;
		}
		amount += 1;
	}

	@Override
	void calcPrice() {
		// TODO Auto-generated method stub

	}

}
