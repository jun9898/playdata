package di.setter02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		
		ApplicationContext factory 
			= new ClassPathXmlApplicationContext("/config/setter.xml");
		
		PlayerInterface p = factory.getBean("player", PlayerInterface.class);
		p.play();
		System.out.println("세번굴린 주사위의 합:"+p.getTotalValue());

	}

}
