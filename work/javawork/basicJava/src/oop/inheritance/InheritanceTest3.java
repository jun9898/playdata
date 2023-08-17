package oop.inheritance;

/*
 * [[ 상속관계에서 생성자가 갖는 특징 ]] 
 * 1. 모든 클래스의 최상위 클래스는 java.lang.Object다.
 * 	  => 자바에서는 객체가 갖는 공통의 특징을 java.lang.Object에 정의해놓고 상속하는 클래스가 없는 경우
 * 		 컴파일러를 통해 자동으로 상속받을 수 있도록 하고있다.
 * 	  => JVM에서 실행될때 문제가 없으려면 내부에서 인식하는 공통의 타입을 갖고 있어야 하며
 * 		 java.lang.Object
 * 2. 상위클래스가 먼저 메모리에 올라갈 수 있도록 모든 생성자의 첫 번째 문장에는 super()가 생략되어 있다.
 * 	  즉, 부모클래스의 기본생성자를 호출하는 명령문이 생략
 * 	  -------------------
 * 		super()
 * 		  |
 * 		  |____ 기본으로 부모의 기본 생성자가 호출되고 있으나 명시적으로 매개변수가 있는 부모의 생성자를 호출할 수 있다.
 * 				명시적으로 부모의 생성자를 호출하면 컴파일러는 super()를 생성자의 첫 문장에 추가하지 않는다.
 * 		  
 * 
 * 	  => 단, 생성자 호출문이 없는 경우
 * 3. 부모의 매개변수가 있는 생성자를 호출하는 경우 super()를 이용한다.
 * 	  super(매개변수1, 매개변수2 ....)
 * 	  ---------------------------
 * 			|_ 부모클래스의 매개변수있는 생성자를 호출
 * 		 
 * 4. 부모클래스는 직접 생성해서 쓰지 않으므로 부모가 갖고 있는 멤버변수는 자식 객체를 통해 설정하는 것이 일반적
 * 5. 생성자는 상속되지 않는다.
 * 
 */

class SuperA {

	private String name;
	private int age;

	public SuperA(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public SuperA() {
		System.out.println("부모의 생성자");
	}
}

class SubA extends SuperA{

	String subdata;

	public SubA(String name, int age, String subdata) {

		super(name,age);
		this.subdata = subdata;

		System.out.println("자식의 생성자");
	}
	
}

class SuperB {
	String name;
	public SuperB(String name) {
		this.name = name;
	}
}

class SubB extends SuperB {
	public SubB(){
		super("String");
	}
}

public class InheritanceTest3 {
	public static void main(String[] args) {
		SubA obj = new SubA("name", 26,"subdata");
	}
}
