package annotation.exam03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageBean implements InterMessage{
	
	@Value("name")
	private String name;
	@Value("greeting")
	private String greeting;
	@Autowired
	@Qualifier("fileOutputter")
	private Outputter outputter;

	public MessageBean() {
		super();
	}

	public MessageBean(String name, String greeting, Outputter outputter) {
		super();
		this.name = name;
		this.greeting = greeting;
		this.outputter = outputter;
	}

	@Override
	public void sayHello() {
		outputter.output("name : "+ name + ", greeting : " + greeting);

	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	

}
