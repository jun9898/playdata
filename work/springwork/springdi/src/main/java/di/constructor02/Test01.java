package di.constructor02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	public static void main(String[] args) {
		
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("/config/constructor.xml");
		
//		PlayerInterface p = (PlayerInterface)factory.getBean("play");
		PlayerInterface p = factory.getBean("play", PlayerInterface.class);
		p.play();
		System.out.println("�������� �ֻ����� ��:"+p.getTotalValue());
	}

}
