package oop.basic;

// StaticMethodDemo를 테스트할 수 있는 클레스
public class StaticMethodDemoTest2 {
	public static void main(String[] args) {
		StaticMethodDemoTest2 obj = new StaticMethodDemoTest2();
		obj.display();
		test();

	}
	public void display() {
		System.out.println("display");
	}

	public static void test() {
		System.out.println("test");
	}

}
