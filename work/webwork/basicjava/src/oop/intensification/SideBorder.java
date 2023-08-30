package oop.intensification;

public class SideBorder extends Border {
	
	char borderChar;
	
	public SideBorder(Display display, char borderChar) {
		super(display);
		this.borderChar = borderChar;
	}

	@Override
	int getColumns() {
		return display.getColumns() + 2;
	}

	@Override
	int getRows() {
		return 1;
	}

	@Override
	String getRowText(int row) {
		return null;
	}


}
