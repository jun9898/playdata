package oop.basic;
// 동시접속에 대한 처리 - 객체의 멤버변수나 메소드를 접근하는 부분의 부분 로직이나 메소드 앞에 
// synchronized 처리 해줘야 한다.
public class Singleton {

	private static Singleton singleton = new Singleton();
	private Singleton() {
		System.out.println("인스턴스를 생성했습니다.");
	}

	public synchronized static Singleton getInstance() {
		return singleton;
	}

}
