package assignment.date0818;

public abstract class Factory {
	int openHour;
	int closeHour;
	String name;

	public Factory(String name, int openHour, int closeHour) {
		super();
		this.name = name;
		this.openHour = openHour;
		this.closeHour = closeHour;
	}

	public String getFactoryName() {
		return name;
	}

	public int getWorkingTime() {
		return closeHour - openHour;

		
	}

	abstract int makeProducts(char skill); 

	
	

}
