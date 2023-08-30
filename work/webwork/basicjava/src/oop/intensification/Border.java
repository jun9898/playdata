package oop.intensification;

public abstract class Border extends Display{
	
	Display display;
	
	public Border(Display display) {
		super();
		this.display = display;
	}
}
