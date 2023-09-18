package annotation.exam03;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConsoleOutputter implements Outputter {

	@Override
	public void output(String message) {
		System.out.println(message + " - Console");
	}
	
}
