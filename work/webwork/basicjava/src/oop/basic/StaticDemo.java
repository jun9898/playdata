package oop.basic;

// 인스턴스 변수와 클래스 변수의 비교
// 인스턴스 변수 -> 객체가 소유하는 변수(객체 변수, 객체마다 고유한 값을 갖는 경우 )
// 정적변수(클래스 변수) -> 모든 객체가 공유해서 사용하는 변수(변하지 않는값, 상수)

public class StaticDemo {
	
	public StaticDemo(){
		num++;
		staticNum++;
	}

	int num; // 객체마다 갖는 고유한 값을 저장하는 변수
	static int staticNum; // 모든 객체가 공통으로 사용하는 값이나 누적된 값을 저장하기 위해서 사용하는 변수
	
	public void display() {
		System.out.println("num => " + num + "\tstaticNum => " + staticNum);
	}
	

}
