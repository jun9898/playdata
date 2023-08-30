package assignment.date0818;

public class CarFactory extends Factory implements IWorkingTogether{

	public CarFactory(String factoryName, int openHour, int closeHour) {
		super(factoryName, openHour, closeHour);
	}

	// CarFactory의 객체 CarXYZ를(partner) 인터페이스에 담아 반환했을때
	// 해당 객체가 가지고 있는 name과 skill을 반환받을 수 있는 방법을 모르겠습니다.
	// 인터페이스에 해당 객체를 담아 매개변수로 반환하는 순간 partner에서는 interface에서 구현하라고 명시되어있는
	// workTogether 메소드에만
	// 접근할 수 있는거 아닌가요??
	@Override
	public int workTogether(IWorkingTogether partner) {
		return 2*getWorkingTime();
	}


	@Override
	int makeProducts(char skill) {
		switch (skill) {
			case 'A': {
				return 3*getWorkingTime();
			}
			case 'B': {
				return 2*getWorkingTime();
			}
			case 'C': {
				return 1*getWorkingTime();
			}
			default: {
				return 0;
			}
		}
	}

}
