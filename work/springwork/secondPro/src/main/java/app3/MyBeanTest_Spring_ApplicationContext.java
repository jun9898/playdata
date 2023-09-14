package app3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ApplicationContext를 이용해서 작업
 * 	1. ApplicationContext생성
 *  2. getBean을 이용해서 lookup
 */
public class MyBeanTest_Spring_ApplicationContext {
	public static void main(String[] args) {
		// 1. IoC 컨테이너 생성 - ApplicationContext
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/bean.xml");
		System.out.println("+++++++++++++++++ApplicationContext 객체생성 후++++++++++++++++++");
		// 2. 원하는 객체를 lookup
		MyBean obj = (MyBean)factory.getBean("mybean");
		System.out.println("+++++++++++++++++getBean 호출 후++++++++++++++++++");
		run(obj);
		show(obj);
		change(obj);
		
	}
	public static void run(MyBean obj) {
		System.out.println("================");
		obj.testHello("jbj");
		System.out.println("================");
	}
	public static void show(MyBean obj) {
		obj.testHello("jbj");
		obj.testHello("jbj");
		obj.testHello("jbj");
	}
	public static void change(MyBean obj) {
		System.out.println("*****************");
		obj.testHello("jbj");
		System.out.println("*****************");
		
	}
}
