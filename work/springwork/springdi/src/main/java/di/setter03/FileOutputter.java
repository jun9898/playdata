package di.setter03;

public class FileOutputter implements Outputter {

	@Override
	public void output(String message) {
		System.out.println(message + " - File");
	}
	public void setFilePath(String filePath) {
		System.out.println(filePath);
	}

}
