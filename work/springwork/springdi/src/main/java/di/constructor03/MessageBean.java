package di.constructor03;

public class MessageBean implements InterMessage{
	
	private String name;
	private String greeting;
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
