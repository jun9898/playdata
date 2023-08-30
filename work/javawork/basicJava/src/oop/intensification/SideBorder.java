package oop.intensification;

public class SideBorder extends Border {
	
	char borderChar;
	
	public SideBorder(Display display, char borderChar) {
		super(display);
		this.borderChar = borderChar;
	}

	@Override
	int getColumns() {
		return display.getColumns();
	}

	@Override
	int getRows() {
		// TODO Auto-generated method stub
		return super.getRows();
	}

	@Override
	String getRowText(int row) {
		// TODO Auto-generated method stub
		return super.getRowText(row);
	}


}
