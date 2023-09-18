package di.setter03;

public class ConsoleOutputter implements Outputter {

	@Override
	public void output(String message) {
		System.out.println(message + " - Console");
	}
	
}
