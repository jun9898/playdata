package assignment.date0818;

public class CarFactory extends Factory implements IWorkingTogether{

	public CarFactory(String factoryName, int openHour, int closeHour) {
		super(factoryName, openHour, closeHour);
	}

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
