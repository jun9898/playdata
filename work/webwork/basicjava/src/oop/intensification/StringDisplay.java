package oop.intensification;

public class StringDisplay extends Display {

	String string;
	
	public StringDisplay(String string) {
		super();
		this.string = string;
	}

	@Override
	int getColumns() {
		return string.getBytes().length;
	}

	@Override
	int getRows() {
		return 1;
	}

	@Override
	String getRowText(int row) {
		if (row == 0) {
			return string;
		} else {
			return null;
		}
	}

}
