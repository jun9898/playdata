package annotation.exam03;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FileOutputter implements Outputter {

	@Override
	public void output(String message) {
		System.out.println(message + " - File");
	}

	public void setFilePath(String filePath) {
		System.out.println(filePath);
	}

}
