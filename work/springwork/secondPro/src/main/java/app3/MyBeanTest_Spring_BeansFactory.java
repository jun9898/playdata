package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 * 스프링 IoC 컨테이너를 이용해서 작업하기
 *  - spring은 빈에 대한 설정정보를 xml, 어노테이션, class에 정의
 *  - BeanFactory의 하위
 *  1. xml 파싱
 *  2. factory클래스 만들기
 *  3. factory에서 제공되는 메소드를 이용해서 객체를 컨테이너에 요청
 *  메소드 - getBean("아이디명")
 *  
 */
public class MyBeanTest_Spring_BeansFactory {
	public static void main(String[] args) {
		// 1. xml 파싱 - xml파일명과 위치정보를 클래스패스에서 찾아서 파싱해서 객체로 관리
		Resource res = new ClassPathResource("/config/bean.xml");
		System.out.println("++++++++++++++resource객체 생성 후+++++++++++++++++");
		// 2. spring이 제공하느 IoC컨테이너(객체를 생성하고 관리하는 기능을 갖고있는 클래스들) 클래스를 생성
		// => IoC 컨테이너가 객체를 생성하기 위해 필요한 설정정보를 담고 있는 객체인 Resource를 전달
		BeanFactory factory = new XmlBeanFactory(res);
		System.out.println("++++++++++++++IoC 컨테이너 생성 후+++++++++++++++++");
		// 3. 필요한 객체를 lookup(요청)
		MyBean obj = (MyBean)factory.getBean("mybean");
		MyBean obj2 = (MyBean)factory.getBean("mybean");
		System.out.println("++++++++++++++getBean호출 후+++++++++++++++++");
		if (obj == obj2) {
			System.out.println("같은객체");
		} else {
			System.out.println("다른객체");
		}
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