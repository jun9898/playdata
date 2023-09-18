package di.setter02;

public class Player implements PlayerInterface{

	Rand d;
	int totalValue=0;
	
	public Player() {
		
	}

	public void setD(Rand d) {
		this.d = d;
	}

	public void play(){
		totalValue=0;
		for (int i = 0; i < 3; i++) {
			totalValue+=d.getDiceValue();
		}
	}

	public int getTotalValue(){
		return totalValue;
	}
}