package oop.polymorphism;
public abstract class Sender {
	String name;
	Sender(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	추상 클래스는 모두가 꼭 가져야 하는 메소드를 선언해주는데 의의가 있다.
//	메소드를 빈 중괄호로 생성할 수도 있지만 그런 방법을 사용할 시 해당 메소드를 구현하는것을 
//	생략해버리는 실수가 나올 수도 있다.
//	요구 사항은 언제든지 추가될 수 있으니 항상 확장에 열려있는 상태로 코드를 설계하는것이 좋다.
	
	public abstract void send();
}

