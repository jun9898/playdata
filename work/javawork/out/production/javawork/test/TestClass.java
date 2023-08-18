package test;

import oop.basic.Person;

// JVM은 현재 작업패키지와 java.lang 패키지만 기본으로 인식
public class TestClass {
	public static void main(String[] args) {

		Person p = new Person();
//  	private 접근 제한자여서 접근 불가능
//		p.name = "BJ";

	}

}
