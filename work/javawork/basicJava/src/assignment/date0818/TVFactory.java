package assignment.date0818;

public class TVFactory extends Factory implements IWorkingTogether{
	
	

	public TVFactory(String name, int openHour, int closeHour) {
		super(name, openHour, closeHour);
	}


	// CarFactory의 객체 CarXYZ를(partner) 인터페이스에 담아 반환했을때
	// 해당 객체가 가지고 있는 name과 skill을 반환받을 수 있는 방법을 모르겠다.
	@Override
	public int workTogether(IWorkingTogether partner) {
		return super.getWorkingTime();
	}

	@Override
	int makeProducts(char skill ) {
		switch (skill) {
			case 'A': {
				return 8*getWorkingTime();
			}
			case 'B': {
				return 5*getWorkingTime();
			}
			case 'C': {
				return 3*getWorkingTime();
			}
			default: {
				return 1;
			}
		}
	}


}
