package annotation.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/anno.xml");
		InterMessage message = factory.getBean("messageBean",InterMessage.class);
		message.sayHello();

	}

}