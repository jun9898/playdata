package oop.polymorphism;

public class RefTypeCastingTest2 {
	public static void main(String[] args) {
		Sub obj1 = new Sub();
		Super obj2 = new Sub();
		Super obj3 = new Super();
		
		if(obj1 == obj2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

//		intanceof 연산자는 참조하는 객체의 타입을 평가한다.
		if (obj3 instanceof Super) {
			System.out.println("Super의 타입이다");
		} else {
			System.out.println("Super의 타입이 아니다.");
		}

		if (obj3 instanceof Sub) {
			System.out.println("Sub의 타입이다");
		} else {
			System.out.println("Sub의 타입이 아니다.");
		}
	}

}
