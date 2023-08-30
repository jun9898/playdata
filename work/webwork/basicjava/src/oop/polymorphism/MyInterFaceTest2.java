package oop.polymorphism;
interface ParentInterA {
	
}

interface ParentInterB {
	
}

class SuperClass {
	public void display() {
		System.out.println("super class");
	}
}

class ChildClass extends SuperClass implements ParentInterA, ParentInterB {
	
}

public class MyInterFaceTest2 {
	public static void main(String[] args) {
		ChildClass obj1 = new ChildClass();
		ParentInterA obj2 = new ChildClass();
		ParentInterB obj3 = new ChildClass();
		SuperClass obj4 = new ChildClass();
	}

}
